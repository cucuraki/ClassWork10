package com.example.classwork10.data.remote.apis


import com.example.classwork10.data.remote.dtos.ChatsDto
import retrofit2.Response
import retrofit2.http.GET

interface ChatsApi {
    @GET("80d25aee-d9a6-4e9c-b1d1-80d2a7c979bf")
    suspend fun getChats(): Response<List<ChatsDto>>
}