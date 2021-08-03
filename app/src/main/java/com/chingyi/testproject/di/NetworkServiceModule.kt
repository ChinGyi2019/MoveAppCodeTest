package com.chingyi.testproject.di

import android.content.Context
import com.chingyi.testproject.data.network.api.MyApi
import com.chingyi.testproject.data.network.RetrofitProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ServiceModule{
    //Service Module
    @Provides
    @Singleton
    fun provideMyApi(context: Context): MyApi {
        return RetrofitProvider.retrofit(context).create(MyApi::class.java)
    }

}