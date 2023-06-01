package com.ewnbd.lifvesafer.commons.view_model.implementation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.ewnbd.lifvesafer.commons.utils.SelectedLanguage
import com.ewnbd.lifvesafer.commons.view_model.interfaces.BaseViewModel


open class BaseViewModelImpl: ViewModel(), BaseViewModel {

    override var mutableLanguage: MutableLiveData<Int> = MutableLiveData(SelectedLanguage.LANGUAGE_ENGLISH)
    override var mutableSubscriptionText: MutableLiveData<String> = MutableLiveData()

}