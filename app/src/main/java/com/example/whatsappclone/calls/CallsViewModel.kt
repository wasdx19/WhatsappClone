package com.example.whatsappclone.calls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatsappclone.database.AppDatabase
import com.example.whatsappclone.database.entities.ChatEntity
import kotlinx.coroutines.*

class CallsViewModel(
    private val appDatabase: AppDatabase
): ViewModel() {

    private val _callsData = MutableLiveData<List<ChatEntity>>()
    val callsData: LiveData<List<ChatEntity>>
        get() = _callsData


    fun onViewCreated(){
        viewModelScope.launch {
            val chats = withContext(Dispatchers.IO){
                appDatabase.chatDao().getAllChats()
            }
            _callsData.value = chats
        }
    }
}