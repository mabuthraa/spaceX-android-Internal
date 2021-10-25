package com.apipas.spacex.presentation.home.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.*
import com.apipas.spacex.data.feature.companyInfo.domain.interactor.GetCompanyInfoInteractor
import com.apipas.spacex.data.feature.launch.domain.interactor.GetLaunchesInteractor
import com.apipas.spacex.data.feature.launch.domain.model.LaunchQueryEntity
import com.apipas.spacex.presentation.base.viewmodel.BaseViewModel
import com.apipas.spacex.presentation.base.viewmodel.ViewState
import com.apipas.spacex.presentation.home.model.HomeCompanyModel
import com.apipas.spacex.presentation.home.model.HomeLaunchItemModel
import com.apipas.spacex.presentation.home.model.mapper.HomeCompanyInfoVMMapper
import com.apipas.spacex.presentation.home.model.mapper.HomeLaunchVMMapper
import com.apipas.spacex.util.io
import com.apipas.spacex.util.ui
import com.carlosgub.coroutines.core.interactor.Interactor
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getCompanyInfoInteractor: GetCompanyInfoInteractor,
    private val getLaunchesInteractor: GetLaunchesInteractor,
) : BaseViewModel() {

    //companyInfo VS
    private val _companyInfoVS = MutableLiveData<ViewState<HomeCompanyModel>>()
    val companyInfoVS: LiveData<ViewState<HomeCompanyModel>> get() = _companyInfoVS

    //companyInfo VS
    private val _launchListVS = MutableLiveData<ViewState<List<HomeLaunchItemModel>>>()
    val launchListVSModel: LiveData<ViewState<List<HomeLaunchItemModel>>> get() = _launchListVS
    val launchList = ObservableArrayList<HomeLaunchItemModel>()

    //mappers to models
    private val companyVMMapper by lazy { HomeCompanyInfoVMMapper() }
    private val launchVMMapper by lazy { HomeLaunchVMMapper() }

    //launchQuery
    private var launchQueryEntity = LaunchQueryEntity()


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun loadData() {
        getCompanyInfo()
        loadLaunchList(true)
    }

    private fun getCompanyInfo() {
        viewModelScope.launch {
            _companyInfoVS.value = ViewState.Loading
            try {
                io {
                    getCompanyInfoInteractor.execute(Interactor.None)
                        .collect {
                            ui {
                                _companyInfoVS.value = ViewState.Success(companyVMMapper.map(it))
                            }
                        }
                }
            } catch (e: Exception) {
                ui { _companyInfoVS.value = ViewState.Error(e) }
            }
        }
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
                        .collect {
                            ui {
                                val item = launchVMMapper.map(it.docs)
                                launchList.addAll(item)
                                launchQueryEntity = launchQueryEntity.copy(
                                    nextPage = it.nextPage,
                                    hasNextPage = it.hasNextPage
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


    fun loadNextLaunches() {
        loadLaunchList(false)
    }

    fun clearLaunches() {
        launchList.clear()
        launchQueryEntity = LaunchQueryEntity()
    }
}