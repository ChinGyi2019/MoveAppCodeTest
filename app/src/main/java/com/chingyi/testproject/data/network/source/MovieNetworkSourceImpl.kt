package com.chingyi.testproject.data.network.source

import com.chingyi.testproject.data.common.movie.MovieNetworkSource
import com.chingyi.testproject.data.network.api.MyApi
import com.chingyi.testproject.data.network.response.toMoveModel
import com.chingyi.testproject.data.network.response.toMovieList
import com.chingyi.testproject.domain.upcoming.model.Movie
import com.chingyi.testproject.helper.executeOrThrow
import javax.inject.Inject

class MovieNetworkSourceImpl @Inject constructor(
private val api : MyApi
): MovieNetworkSource {

    override suspend fun getUpComingMovieList() : List<Movie> {
        return executeOrThrow { api.fetchUpComingMovies() }.toMovieList()
    }

    override suspend fun getPopularMovieList() : List<Movie> {
        return executeOrThrow { api.fetchPopularMovies() }.toMovieList()
    }

    override suspend fun getMovieDetails(id : Long) : Movie {
        return executeOrThrow { api.getMovie(id = id) }.toMoveModel()
    }
}