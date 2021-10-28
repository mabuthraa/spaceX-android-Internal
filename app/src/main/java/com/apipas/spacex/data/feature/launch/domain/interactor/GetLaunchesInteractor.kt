package com.apipas.spacex.data.feature.launch.domain.interactor

import com.apipas.spacex.data.feature.base.domain.model.PagerEntity
import com.apipas.spacex.data.feature.launch.data.repository.LaunchRepository
import com.apipas.spacex.data.feature.launch.domain.model.LaunchEntity
import com.apipas.spacex.data.feature.launch.domain.model.LaunchQueryEntity
import com.carlosgub.coroutines.core.interactor.Interactor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce

class GetLaunchesInteractor(
    private val launchRepository: LaunchRepository
) : Interactor<GetLaunchesInteractor.Params, Flow<PagerEntity<LaunchEntity>>> {

    override fun execute(params: GetLaunchesInteractor.Params): Flow<PagerEntity<LaunchEntity>> {
        return launchRepository.getLaunches(params.launchQueryEntity)
    }

    data class Params(val launchQueryEntity: LaunchQueryEntity)
}