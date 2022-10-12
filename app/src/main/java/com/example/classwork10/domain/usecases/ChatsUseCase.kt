package com.example.classwork10.domain.usecases

import com.example.classwork10.common.responsestate.ResponseState
import com.example.classwork10.domain.models.ChatModel
import com.example.classwork10.domain.repositorys.ChatsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChatsUseCase @Inject constructor(private val repository: ChatsRepository) {
    operator fun invoke(): Flow<ResponseState<List<ChatModel>>> = repository.getChats()
}