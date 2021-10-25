package com.apipas.spacex.presentation.base.viewmodel

sealed class ViewState<out T> {
    object Loading : ViewState<Nothing>()
    data class Error(val throwable: Throwable) : ViewState<Nothing>()
    data class Success<T>(val item: T) : ViewState<T>()

    fun toData(): T? = (this as? Success)?.item
}