package com.ewnbd.lifvesafer.commons.activities

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import app.humbihealth.lifesafer.R
import com.ewnbd.lifvesafer.commons.repository.implementation.PreferencesImpl
import com.ewnbd.lifvesafer.commons.utils.AppUtils
import com.ewnbd.lifvesafer.commons.utils.SelectedLanguage
import com.ewnbd.lifvesafer.commons.view_model.implementation.BaseViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseActivity: AppCompatActivity() {

    protected lateinit var progressDialog: ProgressDialog

    private val baseViewModel: BaseViewModelImpl by viewModels()

    protected var isEnglish = true

    override fun onCreate(savedInstanceState: Bundle?) {
        val preferences = PreferencesImpl(this)
        val language = preferences.getLanguage()
        baseViewModel.mutableLanguage.postValue(language)

        super.onCreate(savedInstanceState)

        progressDialog = ProgressDialog(this, R.style.AlertDialogStyle)
        progressDialog.setCancelable(false)
        progressDialog.setMessage(getString(R.string.just_a_moment))
    }

    override fun attachBaseContext(newBase: Context) {
        val preferences = PreferencesImpl(newBase)
        val language = preferences.getLanguage()
        isEnglish = language == SelectedLanguage.LANGUAGE_ENGLISH
        AppUtils.updateLocale(
            newBase,
            if (isEnglish) SelectedLanguage.LOCALE_ENGLISH else SelectedLanguage.LOCALE_ARABIC
        )

        super.attachBaseContext(newBase)
    }

    protected fun changeLanguage(language: Int) {
        val preferences = PreferencesImpl(this)
        preferences.saveLanguage(language)

        if (language == SelectedLanguage.LANGUAGE_ARABIC) {
            AppUtils.updateLocale(this@BaseActivity, SelectedLanguage.LOCALE_ARABIC)

        } else {
            AppUtils.updateLocale(this@BaseActivity, SelectedLanguage.LOCALE_ENGLISH)
        }
        baseViewModel.mutableLanguage.postValue(language)
        isEnglish = language == SelectedLanguage.LANGUAGE_ENGLISH
    }

    fun onBackPressed(view: View) {
        onBackPressedDispatcher.onBackPressed()
    }

    protected fun showAlert() {
        progressDialog.show()
    }

/*
    fun logoutOfApp(view: View) {
        val logoutAlertBuilder = AlertDialog.Builder(this, R.style.AlertDialogStyle)
        logoutAlertBuilder.setCancelable(false)
        val inflater = this.layoutInflater

        val logoutDialogView = inflater.inflate(R.layout.logout_alert, null, false)
        logoutAlertBuilder.setView(logoutDialogView)

        val logoutAlertDialog = logoutAlertBuilder.create()
        logoutAlertDialog.show()

        logoutDialogView.findViewById<AppCompatTextView>(R.id.cancelButton).setOnClickListener {
            logoutAlertDialog.dismiss()
        }

        logoutDialogView.findViewById<AppCompatTextView>(R.id.saveButton).setOnClickListener {
            logoutAlertDialog.dismiss()
            AppUtils.logout(view.context)
        }
    }
*/

    protected fun dismissAlert() {
        if (!this.isDestroyed && progressDialog.isShowing) progressDialog.dismiss()
    }

}