package com.apipas.spacex.data.feature.companyInfo.domain.interactor

import com.apipas.spacex.data.feature.companyInfo.data.repository.CompanyInfoRepository
import com.apipas.spacex.data.feature.companyInfo.domain.model.CompanyInfoEntity
import com.carlosgub.coroutines.core.interactor.Interactor
import kotlinx.coroutines.flow.Flow

class GetCompanyInfoInteractor(private val repository: CompanyInfoRepository) :
    Interactor<Interactor.None, Flow<CompanyInfoEntity>> {

    override fun execute(params: Interactor.None): Flow<CompanyInfoEntity> =
        repository.getCompanyInfo()
}