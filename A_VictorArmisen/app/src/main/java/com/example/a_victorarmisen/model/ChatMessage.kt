package com.example.a_victorarmisen.model

data class ChatMessage (
        val text: String? = null,
        val timestamp: Long? = null,
        val username: String? = null,
        val avatarUrl: String? = null,
        val userId: String? = null
)

data class ChatModel (
        val data: List<ChatMessage>? = null
)