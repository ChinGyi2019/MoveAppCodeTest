package com.chingyi.testproject.domain.popular.usecase

import com.chingyi.testproject.domain.CoroutineUseCase
import com.chingyi.testproject.domain.DispatcherProvider
import com.chingyi.testproject.domain.upcoming.MovieRepository
import com.chingyi.testproject.domain.upcoming.model.Movie
import java.io.IOException
import javax.inject.Inject

class GetPopularMovieList @Inject constructor(
    dispatcherProvider : DispatcherProvider ,
    private  val repository : MovieRepository
) : CoroutineUseCase<GetPopularMovieList.Params , List<Movie>>(dispatcherProvider = dispatcherProvider){

    data class Params(
        val param: String
    )

    override suspend fun provide(input : Params) :List<Movie> {
        return try {
            repository.getPopularMovieList()
        } catch (e: IOException) {
            throw e
        }
    }
}