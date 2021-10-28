package com.apipas.spacex.presentation.home.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.*
import com.apipas.spacex.data.feature.companyInfo.domain.interactor.GetCompanyInfoInteractor
import com.apipas.spacex.data.feature.companyInfo.domain.model.CompanyInfoEntity
import com.apipas.spacex.data.feature.launch.domain.interactor.GetLaunchesInteractor
import com.apipas.spacex.data.feature.launch.domain.model.LaunchQueryEntity
import com.apipas.spacex.presentation.base.event.common.GoToEvent
import com.apipas.spacex.presentation.base.viewmodel.BaseViewModel
import com.apipas.spacex.presentation.base.viewmodel.ViewState
import com.apipas.spacex.presentation.filter.model.FilterModel
import com.apipas.spacex.presentation.home.fragment.HomeFragmentDirections
import com.apipas.spacex.presentation.home.model.HomeCompanyModel
import com.apipas.spacex.presentation.home.model.HomeLaunchItemModel
import com.apipas.spacex.presentation.home.model.mapper.HomeCompanyInfoVMMapper
import com.apipas.spacex.presentation.home.model.mapper.HomeLaunchVMMapper
import com.apipas.spacex.presentation.home.model.mapper.LaunchFilterInteractorMapper
import com.apipas.spacex.util.Log
import com.apipas.spacex.util.io
import com.apipas.spacex.util.ui
import com.carlosgub.coroutines.core.interactor.Interactor
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getCompanyInfoInteractor: GetCompanyInfoInteractor,
    private val getLaunchesInteractor: GetLaunchesInteractor,
) : BaseViewModel() {

    //mappers to models
    private val companyVMMapper by lazy { HomeCompanyInfoVMMapper() }
    private val launchVMMapper by lazy { HomeLaunchVMMapper() }
    private val filterInteractorMapper by lazy { LaunchFilterInteractorMapper() }

    //companyInfo VS
    private val _companyInfoVS = MutableLiveData<ViewState<HomeCompanyModel>>()
    val companyInfoVS: LiveData<ViewState<HomeCompanyModel>> get() = _companyInfoVS

    //companyInfo VS
    private val _launchListVS = MutableLiveData<ViewState<List<HomeLaunchItemModel>>>()
    val launchListVS: LiveData<ViewState<List<HomeLaunchItemModel>>> get() = _launchListVS

    val launchList = ObservableArrayList<HomeLaunchItemModel>()

    //launchQuery
    @Volatile
    private var launchQueryEntity =
        LaunchQueryEntity(filterEntity = filterInteractorMapper.map(FilterModel()))

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun loadData() {
        getCompanyInfo()
        loadLaunchList(true)
    }

    private fun getCompanyInfo() {
        simpleLaunch<CompanyInfoEntity, HomeCompanyModel>(
            viewState = _companyInfoVS,
            flowExecutionBlock = getCompanyInfoInteractor.execute(Interactor.None),
            mapper = companyVMMapper::map
        )
    }

    private fun loadLaunchList(forceUpdate: Boolean) {
        if (forceUpdate) clearLaunches()
        if (!launchQueryEntity.hasNextPage) {
            // no pages to be loaded
            return
        }
        viewModelScope.launch {
            _launchListVS.value = ViewState.Loading
            try {
                io {
                    getLaunchesInteractor.execute(GetLaunchesInteractor.Params(launchQueryEntity.copy()))
                        .collect { docs ->
                            ui {
                                val item = launchVMMapper.map(docs.docs)
                                //feed RC
                                launchList.addAll(item)
                                launchQueryEntity = launchQueryEntity.copy(
                                    nextPage = docs.nextPage,
                                    hasNextPage = docs.hasNextPage
                                )
                                _launchListVS.value = ViewState.Success(item)
                            }
                        }
                }
            } catch (e: Exception) {
                ui { _launchListVS.value = ViewState.Error(e) }
            }
        }
    }

    private fun clearLaunches() {
        launchList.clear()
        launchQueryEntity = LaunchQueryEntity(filterEntity = launchQueryEntity.filterEntity)
    }

    fun loadMore() {
        loadLaunchList(false)
    }

    fun reload() {
        getCompanyInfo()
        loadLaunchList(true)
    }

    fun onFilterClick() {
        publish(GoToEvent(HomeFragmentDirections.actionHomeFragmentToFilterDialogFragment()))
    }

    fun onLaunchItemClick(launchItemModel: HomeLaunchItemModel) {
        publish(
            GoToEvent(
                HomeFragmentDirections.actionHomeFragmentToMediaDialogFragment(
                    launchItemModel
                )
            )
        )
    }

    fun updateQuery(filterModel: FilterModel) {
        val newFilterEntity = filterInteractorMapper.map(filterModel)
        if (newFilterEntity != launchQueryEntity.filterEntity) {
            launchQueryEntity = launchQueryEntity.copy(filterEntity = newFilterEntity)
            loadLaunchList(true)
        }
    }
}