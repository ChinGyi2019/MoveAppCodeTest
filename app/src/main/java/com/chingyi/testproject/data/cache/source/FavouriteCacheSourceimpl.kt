package com.chingyi.testproject.data.cache.source

import com.chingyi.testproject.data.cache.mapper.toFavouriteMovieTable
import com.chingyi.testproject.data.cache.mapper.toMovieFavouriteTable
import com.chingyi.testproject.data.common.favourite.MovieFavouriteCacheSource
import com.chingyi.testproject.data.common.movie.MovieCacheSource
import com.chingyi.testproject.domain.favourite.model.MovieFavourite
import com.chingyi.testproject.room.database.AppDatabase

class FavouriteCacheSourceImpl(private val db : AppDatabase) : MovieFavouriteCacheSource {
    override suspend fun setMovieFavourite(movieFavourite : MovieFavourite) {
       db.movieFavouriteTableDao().setFavourite(movie = movieFavourite.toMovieFavouriteTable())
    }

    override suspend fun isMovieFavourite(id : Long) : MovieFavourite {
       return db.movieFavouriteTableDao().isFavouriteMovie(id = id).toFavouriteMovieTable()
    }
}