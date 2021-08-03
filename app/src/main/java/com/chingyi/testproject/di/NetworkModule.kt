package com.chingyi.testproject.di

import com.chingyi.testproject.data.common.movie.MovieNetworkSource

import com.chingyi.testproject.data.network.api.MyApi
import com.chingyi.testproject.data.network.source.MovieNetworkSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    //Network layer Dependency
    @Singleton
    @Provides
    fun provideMovieNetworkSource(api : MyApi): MovieNetworkSource {
        return MovieNetworkSourceImpl(api = api)
    }
}