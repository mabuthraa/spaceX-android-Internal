package com.apipas.spacex.data.feature.launch.domain.interactor

import com.apipas.spacex.data.feature.base.domain.model.PagerEntity
import com.apipas.spacex.data.feature.launch.data.repository.LaunchRepository
import com.apipas.spacex.data.feature.launch.domain.model.LaunchEntity
import com.carlosgub.coroutines.core.interactor.Interactor
import kotlinx.coroutines.flow.Flow

class GetLaunchesInteractor(
    private val launchEntity: LaunchRepository
) : Interactor<Interactor.None, Flow<PagerEntity<LaunchEntity>>> {

    override fun execute(params: Interactor.None): Flow<PagerEntity<LaunchEntity>> {
        return launchEntity.getLaunches()
    }
}