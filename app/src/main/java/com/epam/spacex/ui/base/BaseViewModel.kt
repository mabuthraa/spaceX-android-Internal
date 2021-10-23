package com.epam.spacex.ui.base


import androidx.lifecycle.*
import com.epam.spacex.App
import com.epam.spacex.BuildConfig
import com.epam.spacex.R
import com.epam.spacex.event.common.LiveEvent
import com.epam.spacex.event.common.LiveEventMap
import com.epam.spacex.exception.RepositoryErrorType
import com.epam.spacex.exception.RepositoryException
import com.epam.spacex.util.Log
import com.epam.spacex.util.NetworkUtil
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

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


    /**
     *  [loading] to display a loading
     */
    val loading = MutableLiveData<Boolean>().apply { value = false }

    /**
     * [snackbar] to display a msg.
     */
    val snackbar = MutableLiveData<String>()

    fun resetSnackBar() {
        snackbar.value = null
    }

    /**
     * Helper function to call a data load function with a loading, errors will trigger a
     * snackbar.
     *
     * By marking `block` as `suspend` this creates a suspend lambda which can call suspend
     * functions.
     *
     * @param block lambda to actually load data. It is called in the viewModelScope. Before calling the
     *              lambda the loading loading will display, after completion or error the
     *              loading will stop
     */
    open fun launchDataLoad(checkInternet: Boolean = true, block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                //enable loading. Each UI has its own Loading widget
                loading.value = true

                //check internet
                if (checkInternet && !NetworkUtil.verifyAvailableNetwork(App.instance)) {
                    throw RepositoryException(
                        RepositoryErrorType.TYPE_NETWORK,
                        message = App.instance.getString(R.string.global_no_network_connection)
                    )
                }

                //run block
                block()
            } catch (repositoryException: RepositoryException) { //can be override with custom Exception for better handling
                onException(repositoryException)
            } catch (error: Exception) { //can be override with custom Exception for better handling
                onException(RepositoryException(cause = error))
            } finally {
                loading.value = false
            }
        }
    }

    private fun handleError(error: RepositoryException) {
        onException(error)
    }

    protected open fun onException(error: RepositoryException) {

        Log.d(":Error:${error.message}") // be aware sometimes there logs dont appear in console
        val unknownErrorMsg =
            App.instance.getString(com.epam.spacex.R.string.global_unknown_error)
        val msg: String = if (!BuildConfig.DEBUG) {
            //debug
            unknownErrorMsg
        } else {
            //debug
            unknownErrorMsg + error.message
        }
        snackbar.value = msg
    }
}