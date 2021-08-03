package com.chingyi.testproject.data.cache.source

import com.chingyi.testproject.data.cache.mapper.toMovieModel
import com.chingyi.testproject.data.cache.mapper.toMovieTableModel
import com.chingyi.testproject.data.common.movie.MovieCacheSource
import com.chingyi.testproject.domain.upcoming.model.Movie
import com.chingyi.testproject.room.database.AppDatabase
import javax.inject.Inject

class MovieCacheSourceImpl @Inject constructor(
    private val db : AppDatabase
): MovieCacheSource{
    override suspend fun insertMovie(movie : Movie , movieType : String) {
        db.movieTableDao().insertMovie(movie.toMovieTableModel(movieType))
    }

    override suspend fun getMovie(id : Long) : Movie {
       return db.movieTableDao().getMovie(id = id).toMovieModel()
    }

    override suspend fun insertMovies(moviesList : List<Movie>, movieType : String) {
        db.movieTableDao().insertMovies(moviesList.map { it.toMovieTableModel(movieType = movieType) })
    }

    override suspend fun getMovies(movieType : String) : List<Movie> {
       return db.movieTableDao().getMovies(movieType = movieType).map { it.toMovieModel() }
    }
}