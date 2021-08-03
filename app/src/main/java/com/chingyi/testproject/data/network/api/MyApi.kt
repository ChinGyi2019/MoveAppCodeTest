package com.chingyi.testproject.data.network.api


import com.chingyi.testproject.BuildConfig
import com.chingyi.testproject.data.network.response.MovieApiModel
import com.chingyi.testproject.data.network.response.MovieDetailsResponse
import com.chingyi.testproject.data.network.response.UpComingMovieListResponse
import retrofit2.Response
import retrofit2.http.*

interface MyApi {

    @GET("movie/upcoming?api_key=${BuildConfig.APP_SECRET}") // @Query("api_key") apiKey: String?
    suspend fun fetchUpComingMovies():
            Response<UpComingMovieListResponse>

    @GET("movie/popular?api_key=${BuildConfig.APP_SECRET}") // @Query("api_key") apiKey: String?
    suspend fun fetchPopularMovies():
            Response<UpComingMovieListResponse>
//    @Headers("Content-Type: application/json",
//        "Accept: application/json")
    @GET("movie/{id}?api_key=${BuildConfig.APP_SECRET}") // @Query("api_key") apiKey: String?
    suspend fun getMovie(@Path("id") id : Long):
            Response<MovieDetailsResponse>

}