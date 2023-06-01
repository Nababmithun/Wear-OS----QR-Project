package com.ewnbd.lifvesafer.commons.data

import android.util.Log
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class GenericDataResponse<T>(
    @SerializedName("success") val success: Boolean? = false,
    @SerializedName("message") val message: String? = "",
    @SerializedName("data") val data: T? = null,
    @SerializedName("errors") val errors: List<String>? = ArrayList(),
): Serializable {

    fun customErrorMessage(): String? {
        var message = ""

        for (item in errors ?: ArrayList()) {
            message += "\n$item"
        }

        return if (message == "") null else message.trim()
    }

}

class GenericListDataResponse<T>(
    @SerializedName("success") val success: Boolean? = false,
    @SerializedName("message") val message: String? = "",
    @SerializedName("data") var data: ArrayList<T>? = ArrayList(),
    @SerializedName("errors") val errors: List<String>? = ArrayList(),
): Serializable {

    fun customErrorMessage(): String? {
        var message = ""

        for (item in errors ?: ArrayList()) {
            message += "\n$item"
        }

        return if (message == "") null else message.trim()
    }

}