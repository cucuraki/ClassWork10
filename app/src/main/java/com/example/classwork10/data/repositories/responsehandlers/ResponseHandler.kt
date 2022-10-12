package com.example.classwork10.data.repositories.responsehandlers

import com.example.classwork10.common.responsestate.ResponseState
import retrofit2.Response
import javax.inject.Inject

class ResponseHandler @Inject constructor() {
    suspend fun <T, M> safeApiCall(
        call: suspend () -> Response<T>,
        mapper: (T) -> M
    ): ResponseState<M> =
        try {
            val response = call.invoke()
            if (response.isSuccessful)
                ResponseState.Success(mapper(response.body()!!))
            else
                ResponseState.Error(response.errorBody().toString())
        } catch (e: Exception) {
            ResponseState.Error(e.message.toString())
        }
}