package com.example.a_victorarmisen.model

import com.google.gson.annotations.SerializedName

data class UserModel (
        val id: String? = null,
        val name: String? = null,
        @SerializedName("box_art_url") val imageUrl: String? = null
)

data class UserResponse (
        val data: List<UserModel>? = null
)