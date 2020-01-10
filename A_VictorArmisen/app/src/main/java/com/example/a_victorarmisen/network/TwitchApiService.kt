package com.example.a_victorarmisen.network

import com.example.a_victorarmisen.model.GamesResponse
import com.example.a_victorarmisen.model.TWStream
import com.example.a_victorarmisen.model.TWStreamsResponse
import okhttp3.Call
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface TwitchApiService {

    @Headers("Client-ID:  $clientId")
    @GET("streams")
    fun getStreams(): retrofit2.Call<TWStreamsResponse>

    @Headers("Client-ID: $clientId")
    @GET("games")
    fun getGames(@Query("id") gameId: String): retrofit2.Call<GamesResponse>


    //Create https client
    companion object {

        private const val clientId = "ywvglt0gib8rqdly0ejobehqfi071m"
        private val retrofit = Retrofit.Builder()
                .baseUrl("https://api.twitch.tv/helix/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val endpoints = retrofit.create<TwitchApiService>(TwitchApiService::class.java!!)
    }



}