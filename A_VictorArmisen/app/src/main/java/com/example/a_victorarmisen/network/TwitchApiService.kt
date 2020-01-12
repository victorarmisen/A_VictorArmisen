package com.example.a_victorarmisen.network

import com.example.a_victorarmisen.model.GamesResponse
import com.example.a_victorarmisen.model.TWStreamResponse
import com.example.a_victorarmisen.model.UserResponse
import com.example.a_victorarmisen.model.VideoResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface TwitchApiService {

    @Headers("Client-ID:  $clientId")
    @GET("streams")
    fun getStreams(@Query("game_id") gameId: String? = null): retrofit2.Call<TWStreamResponse>

    @Headers("Client-ID: $clientId")
    @GET("games")
    fun getGames(@Query("id") gameId: String): retrofit2.Call<GamesResponse>

    @Headers("Client-ID: $clientId")
    @GET("videos")
    fun getVideos(@Query("id") userId: String): retrofit2.Call<VideoResponse>
/*
    @Headers("Client-ID: $clientId")
    @GET("tags")
    fun getVideos(@Query("broadcaster_id") broad: String): retrofit2.Call<VideoResponse>
*/
    //Create https client
    companion object {

        private const val clientId = "ywvglt0gib8rqdly0ejobehqfi071m"
        private val retrofit = Retrofit.Builder()
                .baseUrl("https://api.twitch.tv/helix/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val endpoints = retrofit.create<TwitchApiService>(TwitchApiService::class.java)
    }



}