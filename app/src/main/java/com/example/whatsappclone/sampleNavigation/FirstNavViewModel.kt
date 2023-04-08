package com.example.whatsappclone.sampleNavigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatsappclone.chats.model.Chats
import kotlinx.coroutines.*

class FirstNavViewModel: ViewModel() {

    private val _showLoader = MutableLiveData<Boolean>()
    val showLoader: LiveData<Boolean>
        get() = _showLoader

    private val _message = MutableLiveData<String>()
    val message: LiveData<String>
        get() = _message

    fun onViewCreated(){
        CoroutineScope(Dispatchers.Main).launch {
            _showLoader.value = true
            withContext(Dispatchers.IO){
                // отправляем запросы, выполняем тяжелые алгоритмы
                makeFakeRequest()
            }
            _message.value = "The request has finished"
            _showLoader.value = false
        }
    }

    private suspend fun makeFakeRequest(){
        delay(3000L)
    }

}