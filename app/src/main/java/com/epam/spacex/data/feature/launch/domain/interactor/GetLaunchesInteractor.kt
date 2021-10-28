package com.epam.spacex.data.feature.launch.domain.interactor

import com.epam.spacex.data.feature.base.domain.model.PagerEntity
import com.epam.spacex.data.feature.launch.data.repository.LaunchRepository
import com.epam.spacex.data.feature.launch.domain.model.LaunchEntity
import com.epam.spacex.data.feature.launch.domain.model.LaunchQueryEntity
import com.carlosgub.coroutines.core.interactor.Interactor
import kotlinx.coroutines.flow.Flow

class GetLaunchesInteractor(
    private val launchRepository: LaunchRepository
) : Interactor<GetLaunchesInteractor.Params, Flow<PagerEntity<LaunchEntity>>> {

    override fun execute(params: GetLaunchesInteractor.Params): Flow<PagerEntity<LaunchEntity>> {
        return launchRepository.getLaunches(params.launchQueryEntity)
    }

    data class Params(val launchQueryEntity: LaunchQueryEntity)
}