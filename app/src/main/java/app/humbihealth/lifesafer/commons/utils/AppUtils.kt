package com.ewnbd.lifvesafer.commons.utils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.ContentResolver
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.location.Geocoder
import android.net.ConnectivityManager
import android.net.Uri
import android.os.LocaleList
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import app.humbihealth.lifesafer.R
import com.ewnbd.lifvesafer.commons.repository.implementation.PreferencesImpl
import com.ewnbd.lifvesafer.commons.repository.interfaces.Preferences

import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.channels.Channel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object AppUtils {

    fun showToast(context: Context, message: String, isLong: Boolean){
        Toast.makeText(context, message, if (isLong) Toast.LENGTH_SHORT else Toast.LENGTH_LONG).show()
    }

    fun hasNetworkConnection(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Service.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

/*
    fun customBatteryIcon(battery: Int): Int {
        if ((battery ?: 0) > 80) {
            return R.drawable.ic_battery_100

        } else if ((battery ?: 0) > 60) {
            return R.drawable.ic_battery_80

        } else if ((battery ?: 0) > 40) {
            return R.drawable.ic_battery_60

        } else if ((battery ?: 0) > 20) {
            return R.drawable.ic_battery_40

        }
        return R.drawable.ic_battery_20
    }
*/

  /*  fun generateHomeMarker(context: Context, latLng: LatLng): MarkerOptions {
        return MarkerOptions()
            .position(latLng)
            .icon(BitmapDescriptorFactory.fromBitmap(generateSmallIcon(context)))
    }
*/
/*
    private fun generateSmallIcon(context: Context): Bitmap {
        val height = 120
        val width = 120
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.ic_location)
        return Bitmap.createScaledBitmap(bitmap, width, height, false)
    }
*/

    fun customizeDateTimeFormat(dateTime: String): String {
        if (dateTime == "") return ""
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        val convertedDate: Date?
        var formattedDate = ""
        try {
            convertedDate = sdf.parse(dateTime)
            formattedDate = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(convertedDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return formattedDate
    }

    fun customizeDateWithDayFormat(dateTime: String): String {
        if (dateTime == "") return ""
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        val convertedDate: Date?
        var formattedDate = ""
        try {
            convertedDate = sdf.parse(dateTime)
            formattedDate = SimpleDateFormat("EEEE, dd MMM, yyyy", Locale.getDefault()).format(convertedDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return formattedDate
    }

    fun customizeDateToMMddyyyy(dateTime: String): String {
        if (dateTime == "") return ""
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        val convertedDate: Date?
        var formattedDate = ""
        try {
            convertedDate = sdf.parse(dateTime)
            formattedDate = SimpleDateFormat("MM-dd-yyyy", Locale.getDefault()).format(convertedDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return formattedDate
    }

    fun customizeTimeFormat(dateTime: String): String {
        if (dateTime == "") return ""
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        val convertedDate: Date?
        var formattedDate = ""
        try {
            convertedDate = sdf.parse(dateTime) ?: return ""
            formattedDate = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(convertedDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return formattedDate
    }

    fun customizeDateFormat(dateTime: String): String {
        if (dateTime == "") return ""
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        val convertedDate: Date?
        var formattedDate = ""
        try {
            convertedDate = sdf.parse(dateTime) ?: return ""
            formattedDate = SimpleDateFormat("dd MMM, yyyy", Locale.getDefault()).format(convertedDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return formattedDate
    }

    fun getSubscriptionDay(serverDate: String): Int {
        if (serverDate == "") return 0
        try {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            dateFormat.timeZone = TimeZone.getTimeZone("UTC")
            val pasTime = dateFormat.parse(serverDate)
            val nowTime = Date()
            val dateDiff = (pasTime?.time ?: nowTime.time) - nowTime.time
            val second: Long = TimeUnit.MILLISECONDS.toSeconds(dateDiff)
            val minute: Long = TimeUnit.MILLISECONDS.toMinutes(dateDiff)
            val hour: Long = TimeUnit.MILLISECONDS.toHours(dateDiff)
            var day: Long = TimeUnit.MILLISECONDS.toDays(dateDiff)

            if (dateDiff <= 0) return 0

            if (second < 60 || minute < 60 || hour < 24) {
                return 1
            }

            if (dateDiff - (day * 84600) > 0) {
                day += 1
            }

            return day.toInt()
        } catch (e: ParseException) {
            return 0
        }
    }

    fun getTimeFromNow(context: Context, serverDate: String): String {
        if (serverDate == "") return ""
        try {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            dateFormat.timeZone = TimeZone.getTimeZone("UTC")
            val pasTime = dateFormat.parse(serverDate)
            val nowTime = Date()
            val dateDiff = nowTime.time - pasTime.time
            val second: Long = TimeUnit.MILLISECONDS.toSeconds(dateDiff)
            val minute: Long = TimeUnit.MILLISECONDS.toMinutes(dateDiff)
            val hour: Long = TimeUnit.MILLISECONDS.toHours(dateDiff)
            val day: Long = TimeUnit.MILLISECONDS.toDays(dateDiff)
            if (second < 60) {
                return context.getString(R.string.now)
            } else if (minute < 60) {
                return "$minute ${context.getString(R.string.minutes)}"
            } else if (hour < 24) {
                return "$hour ${context.getString(R.string.hours)}"
            } else if (day >= 7) {
                return when {
                    day > 360 -> {
                        (day / 360).toString() + " ${context.getString(R.string.years)}"
                    }
                    day > 30 -> {
                        (day / 30).toString() + " ${context.getString(R.string.months)}"
                    }
                    else -> {
                        (day / 7).toString() + " ${context.getString(R.string.weeks)}"
                    }
                }
            } else if (day < 7) {
                return "$day ${context.getString(R.string.days)}"
            }
        } catch (e: ParseException) {
            return ""
        }

        return ""
    }

    fun getTimeAgo(context: Context, serverDate: String): String {
        if (serverDate == "") return ""
        try {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            dateFormat.timeZone = TimeZone.getTimeZone("UTC")
            val pasTime = dateFormat.parse(serverDate)
            val nowTime = Date()
            val dateDiff = nowTime.time - pasTime.time
            val second: Long = TimeUnit.MILLISECONDS.toSeconds(dateDiff)
            val minute: Long = TimeUnit.MILLISECONDS.toMinutes(dateDiff)
            val hour: Long = TimeUnit.MILLISECONDS.toHours(dateDiff)
            val day: Long = TimeUnit.MILLISECONDS.toDays(dateDiff)
            if (second < 60) {
                return context.getString(R.string.now)
            } else if (minute < 60) {
                return "$minute ${context.getString(R.string.minutes)} ${context.getString(R.string.ago)}"
            } else if (hour < 24) {
                return "$hour ${context.getString(R.string.hours)} ${context.getString(R.string.ago)}"
            } else if (day >= 7) {
                return when {
                    day > 360 -> {
                        (day / 360).toString() + " ${context.getString(R.string.years)} ${context.getString(R.string.ago)}"
                    }
                    day > 30 -> {
                        (day / 30).toString() + " ${context.getString(R.string.months)} ${context.getString(R.string.ago)}"
                    }
                    else -> {
                        (day / 7).toString() + " ${context.getString(R.string.weeks)} ${context.getString(R.string.ago)}"
                    }
                }
            } else if (day < 7) {
                return "$day ${context.getString(R.string.days)} ${context.getString(R.string.ago)}"
            }
        } catch (e: ParseException) {
            return ""
        }

        return ""
    }

    fun updateLocale(c: Context, languageCode: String): ContextWrapper {
        val locale = Locale(languageCode)
        var context = c
        val resources: Resources = context.resources
        val configuration: Configuration = resources.configuration
        val localeList = LocaleList(locale)
        LocaleList.setDefault(localeList)
        configuration.setLocales(localeList)
        context = context.createConfigurationContext(configuration)
        return ContextWrapper(context)
    }


    @Throws(IOException::class)
    fun getBytesFromInputStream(`is`: InputStream): ByteArray? {
        val os = ByteArrayOutputStream()
        val buffer = ByteArray(0xFFFF)
        var len = `is`.read(buffer)
        while (len != -1) {
            os.write(buffer, 0, len)
            len = `is`.read(buffer)
        }
        return os.toByteArray()
    }

    fun convertImageToRequestBody(context: Context, imagePath: String, imageName: String, imageSerialisedName: String): MultipartBody.Part? {
        val path = Uri.parse(imagePath) ?: return null

        val resolver: ContentResolver? = context.contentResolver
        var fileInputStream: InputStream? = null
        try {
            fileInputStream = resolver?.openInputStream(path)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        if (fileInputStream == null) {
            return null
        }
        var fileConvertToByte: ByteArray? = null
        try {
            fileConvertToByte = getBytesFromInputStream(fileInputStream)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        if (fileConvertToByte == null) {
            return null
        }

        val requestBody: RequestBody = RequestBody.create("*/*".toMediaTypeOrNull(), fileConvertToByte)
        return MultipartBody.Part.createFormData(
            imageSerialisedName,
            imageName,
            requestBody
        )
    }

    /**
     * Show Notification
     */

}