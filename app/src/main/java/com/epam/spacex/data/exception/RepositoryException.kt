package com.epam.spacex.data.exception

import java.io.IOException


open class RepositoryException(
    val type: RepositoryErrorType = RepositoryErrorType.TYPE_UNEXPECTED,
    cause: Throwable = IOException(),
    message: String? = null
) : Exception(message ?: cause.message, cause) {

}