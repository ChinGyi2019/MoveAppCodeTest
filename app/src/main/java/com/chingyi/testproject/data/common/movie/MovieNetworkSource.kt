package com.chingyi.testproject.data.common.movie

import com.chingyi.testproject.domain.upcoming.model.Movie

interface MovieNetworkSource {
    suspend fun getUpComingMovieList(): List<Movie>

    suspend fun getPopularMovieList(): List<Movie>

    suspend fun getMovieDetails(id : Long): Movie
}