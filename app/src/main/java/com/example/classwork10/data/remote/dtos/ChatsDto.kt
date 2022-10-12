package com.example.classwork10.data.remote.dtos

import com.squareup.moshi.Json

data class ChatsDto(
    val id: Int,
    val email: String,
    @Json(name="first_name")
    val firstName: String,
    @Json(name="last_name")
    val lastName: String,
    val avatar: String,
    @Json(name="message_type")
    val messageType: String,
    @Json(name="last_message")
    val lastMessage: String?,
    @Json(name="unrea_message")
    val unreadMessages: Int,
    @Json(name="is_typing")
    val isTyping: Boolean,
    @Json(name="updated_date")
    val updatedDate: Long = System.currentTimeMillis()
)