package com.ewnbd.lifvesafer.commons.repository.interfaces

import com.ewnbd.lifvesafer.commons.data.models.profile.User

interface Preferences {
    fun saveUserData(data: User)
    fun getUserId(): Int
    fun getUserName(): String
    fun getUserEmail(): String
    fun getUserPhone(): String
    fun getUserPhoto(): String
    fun getUserIsDriver(): Boolean
    fun saveIsUserLoggedIn(data: Boolean)
    fun getIsUserLoggedIn(): Boolean
    fun saveToken(token: String)
    fun getFcmToken(): String
    fun saveFcmToken(token: String)
    fun getToken(): String
    fun saveSentLocation(location: String)
    fun getSentLocation(): String
    fun saveLastTime(time: Long)
    fun getLastTime(): Long
    fun saveCurrentSessionId(id: Int)
    fun getCurrentSessionId(): Int
    fun saveLanguage(id: Int)
    fun getLanguage(): Int
    fun saveUnreadNotification(id: Int)
    fun getUnreadNotification(): Int
    fun saveFcmUploaded(data: Boolean)
    fun getFcmUploaded(): Boolean
    fun saveIntroEnabled(data: Boolean)
    fun getIntroEnabled(): Boolean

    fun clearAll()
}