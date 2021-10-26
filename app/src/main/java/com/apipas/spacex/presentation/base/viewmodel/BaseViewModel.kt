package com.apipas.spacex.presentation.base.viewmodel


import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.apipas.spacex.presentation.base.event.common.LiveEvent
import com.apipas.spacex.presentation.base.event.common.LiveEventMap
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
}