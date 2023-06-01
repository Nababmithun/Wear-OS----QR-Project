package com.ewnbd.lifvesafer.commons.data.models.profile

import android.content.Context
import app.humbihealth.lifesafer.R
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class User: Serializable {

    @SerializedName("id")
    var id: Int? = 0

    @SerializedName("email")
    var email: String? = ""

    @SerializedName("name")
    var name: String? = ""

    @SerializedName("username")
    var username: String? = ""

    @SerializedName("profile_pic")
    var profilePicture: String? = ""

    @SerializedName("is_driver")
    var isDriver: Boolean? = false

    fun customId(context: Context): String {
        return "${context.getString(R.string.id_no)} $id"
    }

}