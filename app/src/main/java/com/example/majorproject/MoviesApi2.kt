package com.example.majorproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi2 {
    @GET("top_rated?")
    fun getTopRatedMovies(@Query("api_key") api_key : String): Call<Movies>
}