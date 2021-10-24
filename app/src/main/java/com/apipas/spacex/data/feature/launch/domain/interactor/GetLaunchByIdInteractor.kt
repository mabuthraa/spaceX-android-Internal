package com.apipas.spacex.data.feature.launch.domain.interactor

import com.apipas.spacex.data.feature.launch.data.repository.LaunchRepository
import com.apipas.spacex.data.feature.launch.domain.model.LaunchEntity
import com.carlosgub.coroutines.core.interactor.Interactor
import kotlinx.coroutines.flow.Flow

class GetLaunchByIdInteractor(
    private val launchEntity: LaunchRepository
) : Interactor<GetLaunchByIdInteractor.Params, Flow<LaunchEntity>> {

    override fun execute(params: Params): Flow<LaunchEntity> {
        return launchEntity.getLaunchByUd(params.id)
    }

    data class Params(val id: String)
}