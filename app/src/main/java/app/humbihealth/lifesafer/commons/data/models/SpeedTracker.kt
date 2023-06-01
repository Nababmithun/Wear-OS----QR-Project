package com.ewnbd.lifvesafer.commons.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class SpeedTracker: Serializable {

    @SerializedName("x_axis")
    var xAxis: ArrayList<String>? = ArrayList()

    @SerializedName("y_axis")
    var yAxis: ArrayList<Float>? = ArrayList()

    @SerializedName("AVG")
    var average: Double? = 0.0

}