package com.chingyi.testproject.helper.viewstate

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import timber.log.Timber
import java.util.concurrent.atomic.AtomicBoolean


class ViewStateLiveData<T> : LiveData<ViewState<T>>() {
    private val pendingError =
            AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in ViewState<T>>) {
        if (hasActiveObservers()) {
            Timber.w(
                    "Multiple observers registered but only one will be notified of changes."
            )
        }
        super.observe(owner, observer)
    }

    fun postLoading() {
        this.postValue(ViewState.Loading())
    }

    fun postSuccess(data: T) {
        this.postValue(ViewState.Success(data))
    }

    fun postError(exception: Throwable, error: String?) {
        this.postValue(ViewState.Error(exception , error))
    }

    companion object {
        private const val TAG = "SingleLiveEvent"
    }
}