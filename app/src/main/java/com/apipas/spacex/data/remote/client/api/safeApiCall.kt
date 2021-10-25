package com.apipas.spacex.data.remote.client.api

import androidx.annotation.StringRes
import com.apipas.spacex.app.SpaceXApp
import com.apipas.spacex.R
import com.apipas.spacex.data.exception.RepositoryErrorType
import com.apipas.spacex.data.exception.RepositoryException
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


@Suppress("UNCHECKED_CAST")
suspend fun <T : Any, D : Any> safeApiCall(
    call: suspend () -> Response<T>,
    mapper: (m: T) -> D
): ApiResult<D> {
    lateinit var res: Response<T>
    try {

        res = call.invoke()
        return if (res.body() == null) {
            ApiResult.Success(Unit as D, res)
        } else if (res.isSuccessful) {
            ApiResult.Success((mapper(res.body()!!)), res)
        } else {
            ApiResult.Error(getGeneralApiException(R.string.global_server_error), res)
        }

    } catch (e: Exception) {
        return ApiResult.Error(
            when (e) {
                is RepositoryException -> e
                is HttpException -> RepositoryException(RepositoryErrorType.TYPE_HTTP, cause = e)
                is IOException -> RepositoryException(RepositoryErrorType.TYPE_NETWORK, cause = e)
                else -> RepositoryException(RepositoryErrorType.TYPE_UNEXPECTED, cause = e)
            }
        )
    }
}

private fun getGeneralApiException(@StringRes msg: Int): RepositoryException {
    return RepositoryException(
        RepositoryErrorType.TYPE_API,
        // Message = "Error Http Code!"
        message = SpaceXApp.instance.getString(msg)
    )
}