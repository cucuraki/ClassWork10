package com.example.classwork10.data.converters

import com.example.classwork10.common.enums.MessageType
import com.example.classwork10.data.remote.dtos.ChatsDto
import com.example.classwork10.domain.models.ChatModel

fun ChatsDto.toModel() = ChatModel(
    id = id,
    email = email,
    firstName = firstName,
    lastName = lastName,
    avatar = avatar,
    messageType = MessageType.stringToType(messageType),
    lastMessage = lastMessage,
    unreadMessage = unreadMessages,
    isTyping = isTyping,
    updatedData = updatedDate
)

fun List<ChatsDto>.toModelList() = this.map { it.toModel() }