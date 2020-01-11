package com.example.a_victorarmisen.model

import com.google.gson.annotations.SerializedName

data class StreamModel(
        var id: String? = null,
        @SerializedName("user_id") val userId: String? = null,
        @SerializedName("game_id") val gameId: String? = null,
        @SerializedName("user_name") val username: String? = null,
        val title: String? = null,
        @SerializedName("viewer_count") val viewCount: String? = null,
        @SerializedName("thumbnail_url") val thumbnailUrl: String? = null

        ) {

        var game: GameModel? = null

        fun getThumbnailUrl(width: Int = 300, height: Int = 300): String? {
            return thumbnailUrl?.replace("{width}",width.toString())?.replace("{height}", height.toString())
        }
}


data class StreamsResponse(
        var data: ArrayList<StreamModel>? = null
)

