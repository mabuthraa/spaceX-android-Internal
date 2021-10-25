package com.apipas.spacex.data.feature.companyInfo.domain.interactor

import kotlinx.coroutines.flow.Flow
import com.apipas.spacex.data.feature.companyInfo.domain.model.CompanyInfoEntity
import com.apipas.spacex.data.feature.companyInfo.data.repository.CompanyInfoRepository
import com.carlosgub.coroutines.core.interactor.Interactor

class GetCompanyInfoInteractor(private val repository: CompanyInfoRepository) :
    Interactor<Interactor.None, Flow<CompanyInfoEntity>> {

    override fun execute(params: Interactor.None): Flow<CompanyInfoEntity> =
        repository.getCompanyInfo()
}