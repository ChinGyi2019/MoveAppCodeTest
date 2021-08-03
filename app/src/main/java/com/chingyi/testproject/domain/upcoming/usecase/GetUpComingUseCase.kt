package com.chingyi.testproject.domain.upcoming.usecase

import com.chingyi.testproject.domain.CoroutineUseCase
import com.chingyi.testproject.domain.DispatcherProvider
import com.chingyi.testproject.domain.upcoming.MovieRepository
import com.chingyi.testproject.domain.upcoming.model.Movie
import java.io.IOException
import javax.inject.Inject

class GetUpComingMovieList @Inject constructor(
    dispatcherProvider : DispatcherProvider ,
    private  val repositoryUpComing : MovieRepository
) : CoroutineUseCase<GetUpComingMovieList.Params , List<Movie>>(dispatcherProvider = dispatcherProvider){

    data class Params(
        val param: String
    )

    override suspend fun provide(input : Params) :List<Movie> {
        return try {
            repositoryUpComing.getUpComingMovieList()
        } catch (e: IOException) {
            throw e
        }
    }
}