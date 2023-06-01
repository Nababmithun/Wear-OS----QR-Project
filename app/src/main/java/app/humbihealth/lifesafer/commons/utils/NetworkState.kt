package com.ewnbd.lifvesafer.commons.utils

class NetworkState<T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): NetworkState<T> {
            return NetworkState(Status.SUCCESS, data, null)
        }

        fun <T> empty(): NetworkState<T> {
            return NetworkState(Status.SUCCESS, null, null)
        }

        fun <T> error(message: String?): NetworkState<T> {
            return NetworkState(Status.ERROR, null, message)
        }

        fun <T> loading(): NetworkState<T> {
            return NetworkState(Status.LOADING, null, null)
        }
    }

}

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}