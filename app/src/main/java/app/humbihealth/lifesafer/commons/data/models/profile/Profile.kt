package com.ewnbd.lifvesafer.commons.data.models.profile

import com.google.gson.annotations.SerializedName

class Profile: java.io.Serializable {

    @SerializedName("prfile")
    var user: User? = null

    @SerializedName("msg_for_user")
    var messageForUser: String? = ""


}