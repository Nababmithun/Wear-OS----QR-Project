package com.ewnbd.lifvesafer.commons.view_model.interfaces

import android.content.Context
import android.provider.ContactsContract
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.ewnbd.lifvesafer.commons.data.GenericDataResponse
import com.ewnbd.lifvesafer.commons.utils.NetworkState
import okhttp3.MultipartBody

interface ProfileViewModel {

    var mutableName: MutableLiveData<String>
    var mutableEmail: MutableLiveData<String>
    var mutableCode: MutableLiveData<String>
    var mutablePhone: MutableLiveData<String>

    var mutableShowError: MutableLiveData<Boolean>

    var mutableProfileUpdateData: MutableLiveData<NetworkState<GenericDataResponse<ContactsContract.Profile>>>

   // var mutableProfilePictureUploadData: MutableLiveData<NetworkState<GenericDataResponse<LoginResponse>>>

    fun onSavePressed(view: View)

    fun uploadPicture(picture: MultipartBody.Part)

}