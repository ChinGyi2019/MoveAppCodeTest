package com.chingyi.testproject.di

import android.app.Application
import com.chingyi.testproject.room.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RoomModule {
    @Singleton
    @Provides
    fun provideDatabase(application: Application) = AppDatabase.getInstance(application)

}