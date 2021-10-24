package com.apipas.spacex.presentation.home.viewmodel

import androidx.lifecycle.*
import com.apipas.spacex.data.feature.companyInfo.domain.interactor.GetCompanyInfoInteractor
import com.apipas.spacex.presentation.base.BaseViewModel
import com.apipas.spacex.presentation.base.viewmodel.ViewState
import com.apipas.spacex.presentation.home.model.HomeCompanyModel
import com.apipas.spacex.presentation.home.model.mapper.HomeCompanyInfoVMMapper
import com.apipas.spacex.util.io
import com.apipas.spacex.util.ui
import com.carlosgub.coroutines.core.interactor.Interactor
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getCompanyInfoInteractor: GetCompanyInfoInteractor,
) : BaseViewModel() {

    private val _companyInfoVS = MutableLiveData<ViewState<HomeCompanyModel>>()
    val companyInfoVS: LiveData<ViewState<HomeCompanyModel>> get() = _companyInfoVS

    private val companyVMMapper by lazy { HomeCompanyInfoVMMapper() }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getCompanyInfo() {
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
}