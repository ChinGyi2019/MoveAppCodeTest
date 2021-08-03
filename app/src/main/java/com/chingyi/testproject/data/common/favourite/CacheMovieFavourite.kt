package com.chingyi.testproject.data.common.favourite

import com.chingyi.testproject.domain.favourite.model.MovieFavourite
import com.chingyi.testproject.room.enity.FavouriteMovieTable

interface MovieFavouriteCacheSource {

    suspend fun setMovieFavourite(movieFavourite : MovieFavourite)

    suspend fun isMovieFavourite(id : Long) : MovieFavourite
}