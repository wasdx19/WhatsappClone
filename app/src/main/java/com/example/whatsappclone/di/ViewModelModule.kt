package com.example.whatsappclone.di

import com.example.whatsappclone.chats.ChatViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { ChatViewModel(get()) }
}