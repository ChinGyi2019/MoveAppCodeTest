package com.chingyi.testproject.data.common.movie

import com.chingyi.testproject.domain.upcoming.MovieRepository
import com.chingyi.testproject.domain.upcoming.model.Movie
import com.chingyi.testproject.helper.NetworkException
import java.lang.Exception
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
private val movieNetworkSource : MovieNetworkSource,
private val movieCacheSource : MovieCacheSource
) : MovieRepository {

    override suspend fun getUpComingMovieList() : List<Movie> {

        try {
          val movieFromNetwork = movieNetworkSource.getUpComingMovieList()
            movieCacheSource.insertMovies(movieFromNetwork, movieType = "upcoming")

        }catch (exception : Exception){
            if (exception is NetworkException) {
                if (exception.errorCode == 404) {
                    //Don't recover from 404
                    throw exception
                }
            }
            val moviesFromCache = movieCacheSource.getMovies(movieType = "upcoming")
            if(moviesFromCache.isEmpty()){
                throw exception
            }
            return moviesFromCache

        }
        return  movieCacheSource.getMovies(movieType = "upcoming")
    }

    override suspend fun getPopularMovieList() : List<Movie> {
        try {
            val movieFromNetwork = movieNetworkSource.getPopularMovieList()
            movieCacheSource.insertMovies(movieFromNetwork, movieType = "popularMovie")

        }catch (exception : Exception){
            if (exception is NetworkException) {
                if (exception.errorCode == 404) {
                    //Don't recover from 404
                    throw exception
                }
            }
            val moviesFromCache = movieCacheSource.getMovies(movieType = "popularMovie")
            if(moviesFromCache.isEmpty()){
                throw exception
            }
            return moviesFromCache

        }
        return  movieCacheSource.getMovies(movieType = "popularMovie")
    }

    override suspend fun getMovieDetails(id : Long, movieType : String) : Movie {
        try {
            val movieFromNetwork = movieNetworkSource.getMovieDetails(id = id)
            movieCacheSource.insertMovie(movieFromNetwork, movieType = movieType)

        } catch (exception : Exception) {
            if (exception is NetworkException) {
                if (exception.errorCode == 404) {
                    //Don't recover from 404
                    throw exception
                }
            }

            return movieCacheSource.getMovie(id = id)

        }

        return movieCacheSource.getMovie(id = id)
    }
}