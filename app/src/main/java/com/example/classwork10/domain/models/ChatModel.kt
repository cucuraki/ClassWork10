package com.example.classwork10.domain.models

import com.example.classwork10.common.enums.MessageType

data class ChatModel(
    val id: Int, val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String,
    val messageType: MessageType,
    val lastMessage: String?,
    val unreadMessage: Int,
    val isTyping: Boolean,
    val updatedData: Long
)
