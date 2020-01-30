package com.example.a_victorarmisen.model

import android.widget.ImageView
import com.google.gson.annotations.SerializedName

data class NewsModel (

        val title_news: String? = null,
        val image_news: String? = null

        //@SerializedName("box_art_url") val imageUrl: String? = null
)

data class NewsResponse (
        val data: List<NewsModel>? = null
)