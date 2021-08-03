package com.chingyi.testproject.helper

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import okhttp3.Interceptor
import okhttp3.Response


class NetworkConnectionInterceptor (context: Context, private val token: String): Interceptor{

    private val applicationContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {

        if(!isAvailable()) {
            throw NetworkException(errorBody = "Make Sure Your Internet Connection! :(",errorCode = 499)
        }
        val original = chain.request()
        val requestBuilder = original.newBuilder()
            .addHeader("Authorization", "Bearer " + token)
            .method(original.method, original.body)
        val request = requestBuilder.build()

        return chain.proceed(request)

    }


    @SuppressLint("ServiceCast")
    private fun isAvailable(): Boolean {
        var result = false
        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        if (Build.VERSION_CODES.BASE >= Build.VERSION_CODES.M) {
            connectivityManager?.let {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    it.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
                        result = when {
                            hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                            hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                            else -> false
                        }
                    }
                }
            }

        }
        else {
            val connectivityManagerTwo = applicationContext
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            connectivityManagerTwo.activeNetworkInfo.also {newtworkInfo->
                result = newtworkInfo != null && newtworkInfo.isConnected
            }
        }
        return result
    }
}