package com.chingyi.testproject.di

import android.app.Application
import android.content.Context
import com.chingyi.testproject.domain.DispatcherProvider
import com.chingyi.testproject.domain.details.usecase.GetMovieDetailsUseCase
import com.chingyi.testproject.domain.popular.usecase.GetPopularMovieList
import com.chingyi.testproject.domain.upcoming.MovieRepository

import com.chingyi.testproject.domain.upcoming.usecase.GetUpComingMovieList
import com.chingyi.testproject.helper.AndroidDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun context(application : Application) : Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun dispatcherProvider() : DispatcherProvider {
        return AndroidDispatcherProvider()
    }
    //UseCase Dependency
    @Singleton
    @Provides
    fun upComingMovieUseCase(dispatcherProvider: DispatcherProvider,
                             upComingMovieRepository: MovieRepository
    ): GetUpComingMovieList {
        return GetUpComingMovieList(dispatcherProvider = dispatcherProvider,
            repositoryUpComing = upComingMovieRepository)
    }

    @Singleton
    @Provides
    fun popularMovieUseCase(dispatcherProvider: DispatcherProvider,
                             popularMovieRepository: MovieRepository
    ): GetPopularMovieList {
        return GetPopularMovieList(dispatcherProvider = dispatcherProvider,
            repository = popularMovieRepository)
    }

    @Singleton
    @Provides
    fun movieDetailsUseCase(dispatcherProvider: DispatcherProvider,
                            repository: MovieRepository
    ): GetMovieDetailsUseCase {
        return GetMovieDetailsUseCase(dispatcherProvider = dispatcherProvider,
            repository = repository)
    }
}