package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.api.Endpoint
import com.example.movieapp.util.NetworkUtils
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getMovies()
    }

    fun getMovies(){
        val retrofitClient = NetworkUtils.getRetrofitInstance("https://www.omdbapi.com/")
        val endpoint = retrofitClient.create(Endpoint::class.java)

        endpoint.getMoviesByTitle("batman").enqueue(object : retrofit2.Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                var data = mutableListOf<String>()

                response.body()?.keySet()?.iterator()?.forEach {
                    data.add(it)
                }

                println(data.count())
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                println("Não foi")
            }

        })
    }
}