package com.chingyi.testproject.data.common.favourite

import com.chingyi.testproject.domain.favourite.FavouriteMovieRepository
import com.chingyi.testproject.domain.favourite.model.MovieFavourite

class FavouriteMovieRepositoryImpl(
    private val cacheMovieFavouriteSource : MovieFavouriteCacheSource
) : FavouriteMovieRepository {
    override suspend fun setMovieFavourite(movieFavourite : MovieFavourite) {
        cacheMovieFavouriteSource.setMovieFavourite(movieFavourite = movieFavourite)
    }

    override suspend fun isMovieFavourite(id : Long) : MovieFavourite{
      return  cacheMovieFavouriteSource.isMovieFavourite(id = id)
    }
}