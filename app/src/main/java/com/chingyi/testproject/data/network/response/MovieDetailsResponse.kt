package com.chingyi.testproject.data.network.response

import com.chingyi.testproject.domain.upcoming.model.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDetailsResponse (
    @Json(name = "adult")
    val adult: Boolean? = null,
    @Json(name = "backdrop_path")
    val backdropPath: String? = null,
    @Json(name = "belongs_to_collection")
    val belongsToCollection: BelongsToCollection? = null,
    @Json(name = "budget")
    val budget: Long? = null,
    @Json(name = "genres")
    val genres: List<Genre>? = null,
    @Json(name = "homepage")
    val homepage: String? = null,
    @Json(name = "id")
    val id: Long? = null,
    @Json(name = "imdb_id")
    val imdbID: String? = null,
    @Json(name = "original_language")
    val originalLanguage: String? = null,
    @Json(name = "original_title")
    val originalTitle: String? = null,
    @Json(name = "overview")
    val overview: String? = null,
    @Json(name = "popularity")
    val popularity: Double? = null,
    @Json(name = "poster_path")
    val posterPath: String? = null,
    @Json(name = "production_companies")
    val productionCompanies: List<ProductionCompany>? = null,
    @Json(name = "production_countries")
    val productionCountries: List<ProductionCountry>? = null,
    @Json(name = "release_date")
    val releaseDate: String? = null,
    @Json(name = "revenue")
    val revenue: Long? = null,
    @Json(name = "runtime")
    val runtime: Long? = null,
    @Json(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguage>? = null,
    @Json(name = "status")
    val status: String? = null,
    @Json(name = "tagline")
    val tagline: String? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "video")
    val video: Boolean? = null,
    @Json(name = "vote_average")
    val voteAverage: Double? = null,
    @Json(name = "vote_count")
    val voteCount: Long? = null
)

@JsonClass(generateAdapter = true)
data class BelongsToCollection (
    val id: Long? = null,
    val name: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null
)

@JsonClass(generateAdapter = true)
data class Genre (
    @Json(name = "id")
    val id: Long? = null,
    @Json(name = "name")
    val name: String? = null
)
@JsonClass(generateAdapter = true)
data class ProductionCompany (
    @Json(name = "id")
    val id: Long? = null,
    @Json(name = "logo_path")
    val logoPath: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "origin_country")
    val originCountry: String? = null
)
@JsonClass(generateAdapter = true)
data class ProductionCountry (
    @Json(name = "iso_3166_1")
    val iso3166_1: String? = null,
    @Json(name = "name")
    val name: String? = null
)
@JsonClass(generateAdapter = true)
data class SpokenLanguage (
    @Json(name = "english_name")
    val englishName: String? = null,
    @Json(name = "iso_639_1")
    val iso639_1: String? = null,
    @Json(name = "name")
    val name: String? = null
)

fun MovieDetailsResponse.toMoveModel() : Movie{

        return Movie(
            id = id,
            adult = adult ,
            backdropPath = backdropPath ,
            originalLanguage = originalLanguage ,
            originalTitle = originalTitle ,
            //genreIDS = genres,
            originalName = originalTitle,
            overview = overview ,
            popularity = popularity ,
            posterPath = posterPath ,
            releaseDate = releaseDate ,
            title = title ,
            video = video ,
            voteAverage = voteAverage ,
            voteCount = voteCount,
            runTime = runtime
    )
}
