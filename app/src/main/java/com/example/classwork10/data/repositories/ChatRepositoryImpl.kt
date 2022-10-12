package com.example.classwork10.data.repositories

import com.example.classwork10.common.responsestate.ResponseState
import com.example.classwork10.data.converters.toModelList
import com.example.classwork10.data.remote.apis.ChatsApi
import com.example.classwork10.data.repositories.responsehandlers.ResponseHandler
import com.example.classwork10.domain.models.ChatModel
import com.example.classwork10.domain.repositorys.ChatsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val chatsApi: ChatsApi,
    private val handler: ResponseHandler
) : ChatsRepository {
    override fun getChats(): Flow<ResponseState<List<ChatModel>>> = flow {
        emit(ResponseState.Load())
        emit(handler.safeApiCall({ chatsApi.getChats() }, { it.toModelList() }))
    }
}