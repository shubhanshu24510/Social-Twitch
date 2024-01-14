package com.shubhans.socialclone.feature_chat.domain.use_case

data class ChatUseCases(
    val sendMessage: SendMessage,
    val observeChatEvents: ObserveChatEvents,
    val observeMessages: ObserveMessages,
    val getChatsForUser: GetChatsForUser,
    val getMessagesForChat: GetMessagesForChat,
    val initializeRepository: InitializeRepository
)
