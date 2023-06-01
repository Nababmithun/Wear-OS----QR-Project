package com.ewnbd.lifvesafer.network


import androidx.databinding.ktx.BuildConfig
import app.humbihealth.lifesafer.BuildConfig.VERSION_NAME
import app.humbihealth.lifesafer.Constants
import de.hdodenhof.circleimageview.BuildConfig.VERSION_NAME
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.jetbrains.annotations.NotNull
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import kotlin.jvm.Throws

object ApiClient {
    private var okHttpClient: OkHttpClient? = null

    fun getInstance(token: String): Retrofit {
        okHttpClient = null
        initOkHttp(token)

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient!!)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun initOkHttp(token: String) {
        val REQUEST_TIMEOUT = 60
        val httpClient: OkHttpClient.Builder = OkHttpClient().newBuilder()
            .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(interceptor)
        }

        httpClient.addInterceptor(Interceptor { chain ->
            val original: Request = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept-Language", "en")
               // .addHeader("Version-Code", BuildConfig.VERSION_NAME)

            if (token != "") {
                requestBuilder.addHeader("Authorization", "Token $token")
            }

            val request: Request = requestBuilder.build()
            chain.proceed(request)
        })
        okHttpClient = httpClient.build()
    }
}