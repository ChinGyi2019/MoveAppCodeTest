package com.chingyi.testproject.domain.details.usecase

import com.chingyi.testproject.domain.CoroutineUseCase
import com.chingyi.testproject.domain.DispatcherProvider
import com.chingyi.testproject.domain.popular.usecase.GetPopularMovieList
import com.chingyi.testproject.domain.upcoming.MovieRepository
import com.chingyi.testproject.domain.upcoming.model.Movie
import java.io.IOException
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    dispatcherProvider : DispatcherProvider ,
    private  val repository : MovieRepository
) : CoroutineUseCase<GetMovieDetailsUseCase.Params , Movie>(dispatcherProvider = dispatcherProvider){

    data class Params(
        val id: Long,
        val movieType : String
    )

    override suspend fun provide(input : GetMovieDetailsUseCase.Params) : Movie {
        return try {
            repository.getMovieDetails(id = input.id, movieType = input.movieType)
        } catch (e: IOException) {
            throw e
        }
    }
}