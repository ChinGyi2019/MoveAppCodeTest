package com.chingyi.testproject.data.cache.mapper

import com.chingyi.testproject.domain.favourite.model.MovieFavourite
import com.chingyi.testproject.domain.upcoming.model.Movie
import com.chingyi.testproject.room.enity.FavouriteMovieTable
import com.chingyi.testproject.room.enity.MovieTable


fun Movie.toMovieTableModel(movieType : String): MovieTable{
    return MovieTable(
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
        voteCount = voteCount,
        movieType = movieType,

    )
}
fun MovieFavourite.toMovieFavouriteTable() : FavouriteMovieTable{
    return  FavouriteMovieTable(
        id = id,
        isFavourite = isFavourite
    )
}