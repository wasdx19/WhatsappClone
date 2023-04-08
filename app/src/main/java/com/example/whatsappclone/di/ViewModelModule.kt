package com.example.whatsappclone.di

import com.example.whatsappclone.chats.ChatViewModel
import com.example.whatsappclone.sampleNavigation.FirstNavViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { ChatViewModel(get()) }
    factory { FirstNavViewModel() }
}