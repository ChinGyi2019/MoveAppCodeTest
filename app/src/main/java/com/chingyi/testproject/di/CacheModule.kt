package com.chingyi.testproject.di

import com.chingyi.testproject.data.cache.source.FavouriteCacheSourceImpl
import com.chingyi.testproject.data.cache.source.MovieCacheSourceImpl
import com.chingyi.testproject.data.common.favourite.MovieFavouriteCacheSource
import com.chingyi.testproject.data.common.movie.MovieCacheSource
import com.chingyi.testproject.data.common.movie.MovieNetworkSource
import com.chingyi.testproject.data.network.api.MyApi
import com.chingyi.testproject.data.network.source.MovieNetworkSourceImpl
import com.chingyi.testproject.room.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CacheModule {
    @Singleton
    @Provides
    fun provideMovieCacheSource(db : AppDatabase): MovieCacheSource {
        return MovieCacheSourceImpl(db = db)
    }

    @Singleton
    @Provides
    fun provideMovieFavouriteCacheSource(db : AppDatabase): MovieFavouriteCacheSource {
        return FavouriteCacheSourceImpl(db = db)
    }
}