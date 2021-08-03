package com.chingyi.testproject.data.network.response

import com.chingyi.testproject.domain.upcoming.model.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UpComingMovieListResponse (
    @Json(name = "dates")
    val dates: Dates? = null,
    @Json(name = "page")
    val page: Long? = null,
    @Json(name = "results")
    val movies: List<MovieApiModel>? = null,
    @Json(name = "totalPages")
    val totalPages: Long? = null,
    @Json(name = "totalResults")
    val totalResults: Long? = null
)
@JsonClass(generateAdapter = true)
data class Dates (
    @Json(name = "maximum")
    val maximum: String? = null,
    @Json(name = "minimum")
    val minimum: String? = null
)
@JsonClass(generateAdapter = true)
data class MovieApiModel (
    @Json(name = "adult")
    val adult: Boolean? = null,
    @Json(name = "backdrop_path")
    val backdropPath: String? = null,
    @Json(name = "genre_ids")
    val genreIDS: List<Long>? = null,
    @Json(name = "id")
    val id: Long? = null,
    @Json(name = "original_language")
    val originalLanguage: String? = null,
    @Json(name = "original_title")
    val originalTitle: String? = null,
    @Json(name = "original_name")
    val originalName: String? = null,
    @Json(name = "overview")
    val overview: String? = null,
    @Json(name = "popularity")
    val popularity: Double? = null,
    @Json(name = "poster_path")
    val posterPath: String? = null,
    @Json(name = "release_date")
    val releaseDate: String? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "video")
    val video: Boolean? = null,
    @Json(name = "vote_average")
    val voteAverage: Double? = null,
    @Json(name = "vote_count")
    val voteCount: Long? = null
)


fun UpComingMovieListResponse.toMovieList():List<Movie>{
    return movies?.map { it.toMovieModel() } ?: emptyList()
}

fun MovieApiModel.toMovieModel() : Movie{
    return Movie(
        id = id ,
        adult = adult ,
        backdropPath = backdropPath ,
        originalLanguage = originalLanguage ,
        originalTitle = originalTitle ,
        genreIDS = genreIDS,
        originalName = originalName,
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