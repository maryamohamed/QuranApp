package com.tech.quranapp.utils

import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

class NetworkState (val status: Status, val massage: Any? = null, val data: Any? = null) {

    enum class Status {
        RUNNING, FAILED, SUCCESS
    }

    companion object {
        fun getLoaded(dataSuccess: Any?): NetworkState {
            return NetworkState(Status.SUCCESS, data = dataSuccess)
        }

        var LOADING: NetworkState = NetworkState(Status.RUNNING)

        fun getErrorMessage(throwable: Throwable): NetworkState {
            return when (throwable) {
                is IOException -> {
                    NetworkState(Status.FAILED, "No Connection ")
                } is SocketTimeoutException -> {
                    NetworkState(Status.FAILED, "Bad Connection")
                } is HttpException -> {
                    NetworkState(Status.FAILED, "ادخل رقم قومي صحيح ")
                } else -> {
                    NetworkState(Status.FAILED, "Error")
                }
            }
        }

        fun getErrorMessage(massage: String): NetworkState {
            return NetworkState(Status.FAILED, massage)
        }
    }
}