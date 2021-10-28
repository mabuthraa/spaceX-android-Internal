package com.apipas.spacex.presentation.base.viewmodel


import androidx.lifecycle.*
import com.apipas.spacex.presentation.base.event.base.LiveEvent
import com.apipas.spacex.presentation.base.event.base.LiveEventMap
import com.apipas.spacex.util.io
import com.apipas.spacex.util.ui
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import kotlin.reflect.KClass

abstract class BaseViewModel : ViewModel(), LifecycleObserver, KoinComponent {

    private val liveEventMap = LiveEventMap()

    fun <T : LiveEvent> subscribe(
        lifecycleOwner: LifecycleOwner,
        eventClass: KClass<T>,
        eventObserver: Observer<T>
    ) {
        liveEventMap.subscribe(lifecycleOwner, eventClass, eventObserver)
    }

    fun <T : LiveEvent> publish(event: T) {
        liveEventMap.publish(event)
    }

    open fun <E, T> simpleLaunch(
        viewState: MutableLiveData<ViewState<T>>,
        flowExecutionBlock: Flow<E>,
        mapper: (E) -> T
    ): Job {
        viewState.value = ViewState.Loading
        return viewModelScope.launch {
            try {
                io {
                    flowExecutionBlock.collect {
                        ui {
                            viewState.value = ViewState.Success(mapper(it))
                        }
                    }
                }
            } catch (e: Exception) {
                ui {
                    viewState.value = ViewState.Error(e)
                }
            }
        }
    }
}