package com.example.classwork10.domain.repositorys

import com.example.classwork10.common.responsestate.ResponseState
import com.example.classwork10.domain.models.ChatModel
import kotlinx.coroutines.flow.Flow


interface ChatsRepository {
    fun getChats(): Flow<ResponseState<List<ChatModel>>>
}