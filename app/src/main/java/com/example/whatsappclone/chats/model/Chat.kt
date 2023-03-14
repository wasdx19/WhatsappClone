package com.example.whatsappclone.chats.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chats(
    val name: String,
    val demoText: String,
    val avatarUrl: String,
    val date: String
): Parcelable