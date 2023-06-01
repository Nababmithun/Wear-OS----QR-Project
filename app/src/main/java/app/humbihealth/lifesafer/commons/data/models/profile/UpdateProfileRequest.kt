package com.ewnbd.lifvesafer.commons.data.models.profile

import com.google.gson.annotations.SerializedName

class UpdateProfileRequest(
    @SerializedName("name") var name: String,
    @SerializedName("email") var email: String,
    @SerializedName("username") var phoneNumber: String,
) : java.io.Serializable {
}