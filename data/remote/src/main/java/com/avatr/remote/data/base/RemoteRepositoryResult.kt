package com.avatr.remote.data.base

sealed class RemoteRepositoryResult<T> {
    data class Success<T>(val data: T) : RemoteRepositoryResult<T>()
    data class Error<T>(val e: Throwable? = null, val message: String? = null) : RemoteRepositoryResult<T>()
}
