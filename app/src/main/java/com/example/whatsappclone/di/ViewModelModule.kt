package com.example.whatsappclone.di

import com.example.whatsappclone.calls.CallsViewModel
import com.example.whatsappclone.calls.addChat.ChatCreateViewModel
import com.example.whatsappclone.chats.ChatViewModel
import com.example.whatsappclone.sampleNavigation.FirstNavViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { ChatViewModel(get()) }
    factory { FirstNavViewModel() }
    factory { CallsViewModel(get()) }
    factory { ChatCreateViewModel(get()) }
}