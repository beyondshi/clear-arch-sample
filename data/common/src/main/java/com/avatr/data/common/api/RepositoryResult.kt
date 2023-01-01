package com.avatr.data.common.api

sealed class RepositoryResult<T> {
    data class Success<T>(val data: T) : RepositoryResult<T>()
    data class Error<T>(val e: Throwable? = null, val message: String? = null) : RepositoryResult<T>()
}
