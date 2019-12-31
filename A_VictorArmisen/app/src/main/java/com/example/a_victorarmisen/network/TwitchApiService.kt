package com.example.a_victorarmisen.network

import retrofit2.Retrofit



interface TwitchApiService {

    fun getStreams() {

    }


    //Create https client
    companion object {
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.twitch.tv/helix")
            .build()

        val endpoints = retrofit.create<TwitchApiService>(TwitchApiService::class.java!!)
    }


}