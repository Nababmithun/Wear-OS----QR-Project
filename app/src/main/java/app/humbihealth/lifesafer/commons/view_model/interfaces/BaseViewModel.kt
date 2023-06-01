package com.ewnbd.lifvesafer.commons.view_model.interfaces

import androidx.lifecycle.MutableLiveData

interface BaseViewModel {
    var mutableLanguage: MutableLiveData<Int>
    var mutableSubscriptionText: MutableLiveData<String>
}