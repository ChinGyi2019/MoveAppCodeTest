package com.chingyi.testproject.data.network

import android.content.Context
import com.chingyi.testproject.BuildConfig
import com.chingyi.testproject.helper.NetworkConnectionInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit

object OkHttpProvider {

    private var okHttpClient: OkHttpClient? = null

    @JvmStatic
    var token : String = ""

    fun okHttpClient(context: Context): OkHttpClient {

        if (okHttpClient == null) {
            val okHttpClientBuilder = OkHttpClient.Builder()

            if (BuildConfig.DEBUG) {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                okHttpClientBuilder.addNetworkInterceptor(httpLoggingInterceptor)

            }

//            val cache = Cache(
//                directory = File(context.cacheDir, "http_cache"),
//                maxSize = 50L * 1024L * 1024L // 50 MiB
//            )

            okHttpClientBuilder
                .addNetworkInterceptor(NetworkConnectionInterceptor(context = context,token = token))
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(30, TimeUnit.SECONDS)
               // .cache(cache)



            okHttpClient = okHttpClientBuilder.build()
        }

        return okHttpClient!!

    }

    fun okHttpScarlet():OkHttpClient{
        if (okHttpClient == null) {
            val okHttpClientBuilder = OkHttpClient.Builder()

            if (BuildConfig.DEBUG) {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                okHttpClientBuilder.addNetworkInterceptor(httpLoggingInterceptor)

            }
            okHttpClientBuilder
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(30, TimeUnit.SECONDS)




            okHttpClient = okHttpClientBuilder.build()
        }

        return okHttpClient!!
    }
}