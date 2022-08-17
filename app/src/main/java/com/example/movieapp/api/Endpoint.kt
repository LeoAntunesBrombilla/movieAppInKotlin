package com.example.movieapp.api

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {
    @GET("?apikey=b4565b94&")
    fun getMoviesByTitle(@Query("t") title: String) : Call<JsonObject>

}