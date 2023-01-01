package com.avatr.remote.data.base

import io.ktor.http.HttpStatusCode

/**
 * The result of a request to the  BFF.
 */
sealed class BffResult<T> {

    /**
     * A successful response from the  BFF including the [response].
     */
    data class Success<T>(val response: T) : BffResult<T>()

    sealed class Failure<T> : BffResult<T>() {

        /**
         * An unsuccessful response from the Charge BFF including a localized
         * [error] describing the failure.
         *
         * @param error The localized error from the Charge BFF backend
         */
        data class LocalizedError<T>(val error: BffError) : Failure<T>()

        /**
         * An unsuccessful response from the Charge BFF which does not include
         * a localized [SmamoBffError].
         *
         * @param httpStatusCode The HTTP status code we've received from
         * the backend
         */
        data class HttpError<T>(val httpStatusCode: HttpStatusCode) : Failure<T>()

        /**
         * We received a response from the Charge BFF which cannot be parsed.
         *
         * @param throwable The exception which was thrown during serialization
         */
        data class SerializationError<T>(val throwable: Throwable) : Failure<T>()

        /**
         * The network request failed because the Charge BFF is not reachable
         * or the device has a bad internet connection.
         *
         * @param throwable The exception which was thrown during the network
         * request
         */
        data class NetworkError<T>(val throwable: Throwable) : Failure<T>()
    }
}
