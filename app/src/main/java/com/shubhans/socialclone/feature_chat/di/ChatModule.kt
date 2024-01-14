package com.shubhans.socialclone.feature_chat.di

import com.shubhans.socialclone.feature_chat.data.remote.ChatApi
import com.shubhans.socialclone.feature_chat.data.repository.ChatRepositoryImpl
import com.shubhans.socialclone.feature_chat.domain.repository.ChatRepository
import com.shubhans.socialclone.feature_chat.domain.use_case.ChatUseCases
import com.shubhans.socialclone.feature_chat.domain.use_case.GetChatsForUser
import com.shubhans.socialclone.feature_chat.domain.use_case.GetMessagesForChat
import com.shubhans.socialclone.feature_chat.domain.use_case.InitializeRepository
import com.shubhans.socialclone.feature_chat.domain.use_case.ObserveChatEvents
import com.shubhans.socialclone.feature_chat.domain.use_case.ObserveMessages
import com.shubhans.socialclone.feature_chat.domain.use_case.SendMessage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
object ChatModule {

    @Provides
    fun provideChatUseCases(repository: ChatRepository): ChatUseCases {
        return ChatUseCases(
            sendMessage = SendMessage(repository),
            observeChatEvents = ObserveChatEvents(repository),
            observeMessages = ObserveMessages(repository),
            getChatsForUser = GetChatsForUser(repository),
            getMessagesForChat = GetMessagesForChat(repository),
            initializeRepository = InitializeRepository(repository)
        )
    }

    @Provides
    @Singleton
    fun provideChatApi(client: OkHttpClient): ChatApi {
        return Retrofit.Builder()
            .baseUrl(ChatApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    fun provideChatRepository(client: OkHttpClient, chatApi: ChatApi): ChatRepository {
        return ChatRepositoryImpl(chatApi, client)
    }
}