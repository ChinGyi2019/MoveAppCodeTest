package com.chingyi.testproject.helper
import java.io.IOException

data class NetworkException constructor(
    val errorBody: String? = null,
    var errorCode: Int = 0
) : IOException()

data class NoInternetException constructor(
    val errorBody : String? = null
): IOException()