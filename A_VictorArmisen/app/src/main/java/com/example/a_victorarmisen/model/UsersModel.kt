package com.example.a_victorarmisen.model

import com.google.gson.annotations.SerializedName


data class UsersModel (
        val description: String ?= null,
        val view_count: Int ?= null,
        val display_name: String ?= null,
        val email: String ?= null,
        @SerializedName("box_art_url") val imageUrl: String? = null
)

data class UsersResponse (
        val data: List<UsersModel>? = null
)