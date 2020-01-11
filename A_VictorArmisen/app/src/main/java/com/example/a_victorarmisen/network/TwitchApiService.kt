package com.example.a_victorarmisen.network

import com.example.a_victorarmisen.model.GamesResponse
import com.example.a_victorarmisen.model.TWStream
import com.example.a_victorarmisen.model.TWStreamsResponse
import com.example.a_victorarmisen.model.UserResponse
import com.example.a_victorarmisen.network.TwitchApiService.Companion.clientId
import okhttp3.Call
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query


interface TwitchApiService {


    @Headers("Client-ID:  $clientId")
    @GET("streams")
    fun getStreams(@Query("game_id") gameId: String? = null): retrofit2.Call<TWStreamsResponse>

    @Headers("Client-ID: $clientId")
    @GET("games")
    fun getGames(@Query("id") gameId: String): retrofit2.Call<GamesResponse>

    @Headers("Client-ID: $clientId")
    @GET("users")
    fun getUsers(@Query("id") userId: String): retrofit2.Call<UserResponse>


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