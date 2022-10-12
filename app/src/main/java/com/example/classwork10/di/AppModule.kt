package com.example.classwork10.di

import com.example.classwork10.data.remote.apis.ChatsApi
import com.example.classwork10.data.repositories.ChatRepositoryImpl
import com.example.classwork10.data.repositories.responsehandlers.ResponseHandler
import com.example.classwork10.domain.repositorys.ChatsRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/").addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(
                    KotlinJsonAdapterFactory()
                ).build()
            )
        )
        .build()

    @Provides
    @Singleton
    fun getApi(retrofit: Retrofit): ChatsApi = retrofit.create(ChatsApi::class.java)

    @Singleton
    @Provides
    fun getRepo(api: ChatsApi, handler: ResponseHandler): ChatsRepository = ChatRepositoryImpl(api, handler)
}