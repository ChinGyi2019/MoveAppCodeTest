package com.chingyi.testproject.domain.favourite

import com.chingyi.testproject.domain.favourite.model.MovieFavourite

interface FavouriteMovieRepository {

    suspend fun setMovieFavourite(movieFavourite : MovieFavourite)

    suspend fun isMovieFavourite(id : Long) : MovieFavourite

}