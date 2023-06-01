package com.ewnbd.lifvesafer.commons.view_model.interfaces

import androidx.lifecycle.MutableLiveData
import com.ewnbd.lifvesafer.commons.data.GenericDataResponse
import com.ewnbd.lifvesafer.commons.data.GenericListDataResponse
import com.ewnbd.lifvesafer.commons.data.models.ShareInfoResponse

import com.ewnbd.lifvesafer.commons.utils.NetworkState

interface TrackingViewModel {
    var mutableShareInfo: MutableLiveData<NetworkState<GenericDataResponse<ShareInfoResponse>>>

  //  var mutableTrackingDetail: MutableLiveData<NetworkState<GenericDataResponse<TrackingSessionDetails>>>
  //  var mutableTrackingSessionHistoryList: MutableLiveData<NetworkState<GenericListDataResponse<TrackingSessionItem>>>

    var mutableBatteryIcon: MutableLiveData<Int>
    var mutableTrackingActive: MutableLiveData<Boolean>

    fun loadTrackingSession()
    fun loadSessionHistory(userId: Int)
    fun loadTrackingDetails(trackingId: Int)

    fun createTrackId()
    fun getTrackData()
}