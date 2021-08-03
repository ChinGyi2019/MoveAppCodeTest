package com.chingyi.testproject.data.common.movie

import com.chingyi.testproject.domain.upcoming.model.Movie
import com.chingyi.testproject.room.enity.MovieTable

interface MovieCacheSource {

   suspend fun insertMovie(movie :Movie, movieType : String)
   suspend fun getMovie(id : Long):Movie

   suspend fun insertMovies(moviesList : List<Movie>, movieType : String)
   suspend fun getMovies(movieType : String) :List<Movie>
}