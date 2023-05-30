package com.dhakasoft.shebaninagent.util

import android.util.Patterns

sealed class Resource<T>(
    val data: T? = null,
    val message: String = ""
) {
    class Loading<T>() : Resource<T>()
    class Success<T>(data: T? = null, message: String = "") : Resource<T>(data, message)
    class Error<T>(message: String = "Oops something went wrong") : Resource<T>(message = message)
}
internal fun String.isValidEmail(): Boolean
        = this.isNotEmpty() &&
        Patterns.EMAIL_ADDRESS.matcher(this).matches()

