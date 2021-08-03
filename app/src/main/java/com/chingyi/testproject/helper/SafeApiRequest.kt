package com.chingyi.testproject.helper

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response



suspend fun<T> executeOrThrow(call:suspend  ()-> Response<T>):T{

    val response = withContext(Dispatchers.IO) { call.invoke() }

    return response.getBodyOrThrowNetworkException()
}

fun <T> Response<T>.getBodyOrThrowNetworkException(): T {

    if (this.isSuccessful.not()) {
        val errorString = this.errorBody()!!
            .byteStream()
            .bufferedReader()
            .use { it.readText() }
        throw NetworkException(errorString, this.code())
    }
    val body = this.body() ?: throw NetworkException()
    return body

}