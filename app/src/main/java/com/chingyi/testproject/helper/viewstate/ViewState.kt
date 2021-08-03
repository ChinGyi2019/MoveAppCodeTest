package com.chingyi.testproject.helper.viewstate

sealed class ViewState<out T> {

    open operator fun invoke(): T? = null

    class Loading<out T>() : ViewState<T>()

    data class Success<out T>(val value: T) : ViewState<T>()

    data class Error<out T>(val exception: Throwable, val errorMessage: String?) : ViewState<T>()

}