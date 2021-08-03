package com.chingyi.testproject.domain.upcoming

import com.chingyi.testproject.domain.favourite.model.MovieFavourite
import com.chingyi.testproject.domain.upcoming.model.Movie

interface MovieRepository {
    suspend fun getUpComingMovieList(): List<Movie>

    suspend fun getPopularMovieList(): List<Movie>

    suspend fun getMovieDetails(id: Long, movieType : String): Movie

}