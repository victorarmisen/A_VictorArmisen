package com.example.a_victorarmisen.network

import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers


interface TwitchApiService {

    @Headers("Client-ID: ywvglt0gib8rqdly0ejobehqfi071m" )
    @GET("/streams")
    fun getStreams() : Call


    //Create https client
    companion object {
        private val retrofit = Retrofit.Builder()
                .baseUrl("https://api.twitch.tv/helix")
                .build()

        val endpoints = retrofit.create<TwitchApiService>(TwitchApiService::class.java)
    }



}