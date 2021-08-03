package com.chingyi.testproject.di

import com.chingyi.testproject.data.common.favourite.FavouriteMovieRepositoryImpl
import com.chingyi.testproject.data.common.favourite.MovieFavouriteCacheSource
import com.chingyi.testproject.data.common.movie.MovieCacheSource
import com.chingyi.testproject.data.common.movie.MovieNetworkSource
import com.chingyi.testproject.data.common.movie.MovieRepositoryImpl
import com.chingyi.testproject.domain.favourite.FavouriteMovieRepository
import com.chingyi.testproject.domain.upcoming.MovieRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    //Repository Dependency
    @Singleton
    @Provides
    fun provideUpComingRepository(movieNetworkSource : MovieNetworkSource,
                                    movieCacheSource : MovieCacheSource) : MovieRepository {
        return MovieRepositoryImpl(
            movieNetworkSource = movieNetworkSource,
            movieCacheSource = movieCacheSource
        )

    }

    @Singleton
    @Provides
    fun provideMovieFavouriteRepository(
        movieCacheSource : MovieFavouriteCacheSource)
    : FavouriteMovieRepository {
        return FavouriteMovieRepositoryImpl(
            movieCacheSource
        )

    }
}