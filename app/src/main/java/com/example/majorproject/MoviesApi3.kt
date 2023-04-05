package com.example.majorproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi3 {
    @GET("upcoming?")
    fun getLatestMovies(@Query("api_key") api_key : String): Call<Movies>
}