package com.epam.spacex.data.remote.client.api

import com.epam.spacex.data.exception.RepositoryException
import retrofit2.Response

sealed class ApiResult<out T : Any> {
    data class Success<out T : Any>(val apiData: T, val res: Response<*>? = null) : ApiResult<T>()
    data class Error(val exception: RepositoryException, val res: Response<*>? = null) : ApiResult<Nothing>()
}