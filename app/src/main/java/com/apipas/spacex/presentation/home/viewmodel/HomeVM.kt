package com.apipas.spacex.presentation.home.viewmodel

import androidx.lifecycle.*
import com.apipas.spacex.data.feature.companyInfo.domain.interactor.GetCompanyInfoInteractor
import com.apipas.spacex.presentation.base.BaseViewModel
import com.apipas.spacex.presentation.home.model.mapper.HomeCompanyInfoVMMapper
import com.apipas.spacex.presentation.home.viewmodel.state.HomeCompanyInfoVS
import com.apipas.spacex.util.io
import com.apipas.spacex.util.ui
import com.carlosgub.coroutines.core.interactor.Interactor
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeVM(private val getCompanyInfoInteractor: GetCompanyInfoInteractor) : BaseViewModel() {

    private val _companyInfoVS = MutableLiveData<HomeCompanyInfoVS>()
    val companyInfoVS: LiveData<HomeCompanyInfoVS> get() = _companyInfoVS

    private val companyVMMapper by lazy { HomeCompanyInfoVMMapper() }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getCompanyInfo() {
        viewModelScope.launch {
            _companyInfoVS.value = HomeCompanyInfoVS.ShowLoader(true)
            try {
                io {
                    getCompanyInfoInteractor.execute(Interactor.None)
                        .collect {
                            ui {
                                _companyInfoVS.value =
                                    HomeCompanyInfoVS.AddCompanyInfo(companyVMMapper.map(it))
                            }
                        }
                }
            } catch (e: Exception) {
                ui { _companyInfoVS.value = HomeCompanyInfoVS.Error(e.message) }
            }
            _companyInfoVS.value = HomeCompanyInfoVS.ShowLoader(false)
        }
    }
}