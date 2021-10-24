package com.apipas.spacex.presentation.home.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.*
import com.apipas.spacex.data.feature.companyInfo.domain.interactor.GetCompanyInfoInteractor
import com.apipas.spacex.data.feature.launch.domain.interactor.GetLaunchesInteractor
import com.apipas.spacex.presentation.base.viewmodel.BaseViewModel
import com.apipas.spacex.presentation.base.viewmodel.ViewState
import com.apipas.spacex.presentation.home.model.HomeCompanyModel
import com.apipas.spacex.presentation.home.model.HomeLaunchItem
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
    private val _launchListVS = MutableLiveData<ViewState<HomeLaunchItem>>()
    val launchListVS: LiveData<ViewState<HomeLaunchItem>> get() = _launchListVS
    val launchList = ObservableArrayList<HomeLaunchItem>()

    //mappers to models
    private val companyVMMapper by lazy { HomeCompanyInfoVMMapper() }
    private val launchVMMapper by lazy { HomeLaunchVMMapper() }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun loadData() {
        getCompanyInfo()
        getInitLaunchList()
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

    private fun getInitLaunchList() {
        launchList.clear()
        viewModelScope.launch {
            _launchListVS.value = ViewState.Loading
            try {
                io {
                    getLaunchesInteractor.execute(Interactor.None)
                        .collect {
                            ui {
                                val item = launchVMMapper.map(it)
                                launchList.add(item)
                                _launchListVS.value = ViewState.Success(item)
                            }
                        }
                }
            } catch (e: Exception) {
                ui { _launchListVS.value = ViewState.Error(e) }
            }
        }
    }
}