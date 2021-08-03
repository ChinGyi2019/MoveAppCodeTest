package com.chingyi.testproject.data.cache.mapper

import com.chingyi.testproject.domain.favourite.model.MovieFavourite
import com.chingyi.testproject.domain.upcoming.model.Movie
import com.chingyi.testproject.room.enity.FavouriteMovieTable
import com.chingyi.testproject.room.enity.MovieTable

fun MovieTable.toMovieModel():Movie{
    return Movie(
        id = id,
        adult = adult ,
        backdropPath = backdropPath ,
        originalLanguage = originalLanguage ,
        originalTitle = originalTitle,
        overview = overview ,
        popularity = popularity ,
        posterPath = posterPath ,
        releaseDate = releaseDate ,
        title = title ,
        video = video ,
        voteAverage = voteAverage ,
        voteCount = voteCount

    )
}

fun FavouriteMovieTable.toFavouriteMovieTable() : MovieFavourite{
    return MovieFavourite(
        id = id,
        isFavourite = isFavourite
    )
}