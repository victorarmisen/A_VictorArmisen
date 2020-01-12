package com.example.a_victorarmisen.model


import com.google.gson.annotations.SerializedName

data class VideoModel (
        val id: String? = null,
        val name: String? = null,
        val url: String? = null,
        @SerializedName("box_art_url") val imageUrl: String? = null
)

data class VideoResponse (
        val data: List<VideoModel>? = null
)