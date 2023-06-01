package com.ewnbd.lifvesafer.commons.repository.implementation

import android.content.Context
import android.content.SharedPreferences
import com.ewnbd.lifvesafer.commons.data.models.profile.User
import com.ewnbd.lifvesafer.commons.repository.interfaces.Preferences
import com.ewnbd.lifvesafer.commons.utils.PreferenceConstants
import com.ewnbd.lifvesafer.commons.utils.SelectedLanguage

import javax.inject.Inject

class PreferencesImpl @Inject constructor(private val context: Context): Preferences {

    private var preference: SharedPreferences

    init {
        preference = context.getSharedPreferences(PreferenceConstants.PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    override fun saveUserData(data: User) {
        val edit = preference.edit()
        edit.putInt(PreferenceConstants.USER_ID, data.id ?: 0)
        edit.putString(PreferenceConstants.USER_NAME, data.name ?: "")
        edit.putString(PreferenceConstants.USER_EMAIL, data.email ?: "")
        edit.putString(PreferenceConstants.USER_PHONE, data.username ?: "")
        edit.putBoolean(PreferenceConstants.USER_IS_DRIVER, data.isDriver ?: false)
        edit.putString(PreferenceConstants.PROFILE_PICTURE, data.profilePicture ?: "")
        edit.apply()
    }

    override fun getUserId(): Int {
        return preference.getInt(PreferenceConstants.USER_ID, 0)
    }

    override fun getUserName(): String {
        return preference.getString(PreferenceConstants.USER_NAME, "") ?: ""
    }

    override fun getUserEmail(): String {
        return preference.getString(PreferenceConstants.USER_EMAIL, "") ?: ""
    }

    override fun getUserPhone(): String {
        return preference.getString(PreferenceConstants.USER_PHONE, "") ?: ""
    }

    override fun getUserPhoto(): String {
        return preference.getString(PreferenceConstants.PROFILE_PICTURE, "") ?: ""
    }

    override fun getUserIsDriver(): Boolean {
        return preference.getBoolean(PreferenceConstants.USER_IS_DRIVER, false)
    }

    override fun saveIsUserLoggedIn(data: Boolean) {
        val edit = preference.edit()
        edit.putBoolean(PreferenceConstants.IS_LOGGED_IN, data)
        edit.apply()
    }

    override fun getIsUserLoggedIn(): Boolean {
        return preference.getBoolean(PreferenceConstants.IS_LOGGED_IN, false)
    }

    override fun saveToken(token: String) {
        val edit = preference.edit()
        edit.putString(PreferenceConstants.SERVER_TOKEN, token)
        edit.apply()
    }

    override fun getFcmToken(): String {
        return preference.getString(PreferenceConstants.FIREBASE_TOKEN, "") ?: ""
    }

    override fun saveFcmToken(token: String) {
        val edit = preference.edit()
        edit.putString(PreferenceConstants.FIREBASE_TOKEN, token)
        edit.apply()
    }

    override fun getToken(): String {
        return preference.getString(PreferenceConstants.SERVER_TOKEN, "") ?: ""
    }

    override fun saveSentLocation(location: String) {
        val edit = preference.edit()
        edit.putString(PreferenceConstants.SENT_LOCATION, location)
        edit.apply()
    }

    override fun getSentLocation(): String {
        return preference.getString(PreferenceConstants.SENT_LOCATION, "") ?: ""
    }

    override fun saveLastTime(time: Long) {
        val edit = preference.edit()
        edit.putLong(PreferenceConstants.SENT_TIME, time)
        edit.apply()
    }

    override fun getLastTime(): Long {
        return preference.getLong(PreferenceConstants.SENT_TIME, 0)
    }

    override fun saveCurrentSessionId(id: Int) {
        val edit = preference.edit()
        edit.putInt(PreferenceConstants.CURRENT_SESSION_ID, id)
        edit.apply()
    }

    override fun getCurrentSessionId(): Int {
        return preference.getInt(PreferenceConstants.CURRENT_SESSION_ID, 0)
    }

    override fun saveLanguage(id: Int) {
        val edit = preference.edit()
        edit.putInt(PreferenceConstants.LANGUAGE, id)
        edit.apply()
    }

    override fun getLanguage(): Int {
        return preference.getInt(PreferenceConstants.LANGUAGE, SelectedLanguage.LANGUAGE_ENGLISH)
    }

    override fun saveUnreadNotification(data: Int) {
        val edit = preference.edit()
        edit.putInt(PreferenceConstants.NOTIFICATION_UNREAD, data)
        edit.apply()
    }

    override fun getUnreadNotification(): Int {
        return preference.getInt(PreferenceConstants.NOTIFICATION_UNREAD, 0)
    }

    override fun saveFcmUploaded(data: Boolean) {
        val edit = preference.edit()
        edit.putBoolean(PreferenceConstants.IS_TOKEN_UPLOADED, data)
        edit.apply()
    }

    override fun getFcmUploaded(): Boolean {
        return preference.getBoolean(PreferenceConstants.IS_TOKEN_UPLOADED, false)
    }

    override fun saveIntroEnabled(data: Boolean) {
        val edit = preference.edit()
        edit.putBoolean(PreferenceConstants.IS_INTRO_ENABLED, data)
        edit.apply()
    }

    override fun getIntroEnabled(): Boolean {
        return preference.getBoolean(PreferenceConstants.IS_INTRO_ENABLED, true)
    }



    override fun clearAll() {
        val edit = preference.edit()
        edit.clear()
        edit.apply()
    }

}