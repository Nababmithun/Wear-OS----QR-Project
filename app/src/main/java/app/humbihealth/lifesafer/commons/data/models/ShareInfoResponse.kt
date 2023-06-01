package com.ewnbd.lifvesafer.commons.data.models

import com.ewnbd.lifvesafer.commons.data.models.profile.User
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ShareInfoResponse: Serializable {

    @SerializedName("id")
    var id: Int? = 0

    @SerializedName("user")
    var user: User? = null

    @SerializedName("qr_code")
    var qrImage: String? = ""

    @SerializedName("track_id")
    var trackId: String? = ""

}