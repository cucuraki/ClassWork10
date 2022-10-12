package com.example.classwork10.ui.chatsfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.classwork10.common.responsestate.ResponseState
import com.example.classwork10.common.types.Inflater
import com.example.classwork10.domain.models.ChatModel
import com.example.classwork10.domain.usecases.ChatsUseCase
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class ChatsViewModel @Inject constructor(private val useCase: ChatsUseCase) : ViewModel() {
    private val mutStateFlow: MutableStateFlow<ResponseState<List<ChatModel>>> =
        MutableStateFlow(ResponseState.Error(""))
    val stateFlow = mutStateFlow.asStateFlow()

    fun getChats() {
        viewModelScope.launch {
            useCase.invoke().collect {
                mutStateFlow.value = it
            }
        }
    }
}