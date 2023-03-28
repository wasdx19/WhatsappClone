package com.example.whatsappclone.chats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.whatsappclone.chats.model.Chats
import com.example.whatsappclone.network.AnimeListDTO
import com.example.whatsappclone.network.ApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatViewModel(
    private val apiServices: ApiServices
): ViewModel() {

    private val _basketDetailData = MutableLiveData<List<Chats>>()
    val basketDetailData: LiveData<List<Chats>>
        get() = _basketDetailData

    private val _success = MutableLiveData<Unit>()
    val success: LiveData<Unit>
        get() = _success

    private val animeList = mutableListOf<Chats>()

    fun onViewCreated(){
        apiServices.getAnimeList().enqueue(object : Callback<AnimeListDTO> {
            override fun onResponse(call: Call<AnimeListDTO>, response: Response<AnimeListDTO>) {
                val responseSuccess = response.body()

                responseSuccess?.let {animeDTO ->
                    animeDTO.data.forEach {
                        animeList.add(
                            Chats(
                                name = it.attributes.slug,
                                demoText = it.attributes.description,
                                avatarUrl = it.attributes.posterImage.original,
                                date = it.attributes.averageRating
                            )
                        )
                    }

                    //_basketDetailData.value = animeList
                    _success.value = Unit
                }
            }

            override fun onFailure(call: Call<AnimeListDTO>, t: Throwable) {
                //Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun getChatSampleData() = mutableListOf<Chats>().apply {
        (0..20).forEach {index ->
            if(index%2 == 0) {
                add(
                    Chats(
                        name = "Ansar",
                        demoText = "Hello everyone!!!",
                        avatarUrl = "https://static.life.ru/publications/2022/7/19/691126209796.8171.jpeg",
                        date = "02.02.2023"
                    )
                )
            } else if(index%3 == 0){
                add(
                    Chats(
                        name = "Kaira",
                        demoText = "Ans Ans!!!",
                        avatarUrl = "https://sun9-33.userapi.com/s/v1/if1/_tGuL3gHjX9UHw5965lLOKamdP8elM-quxp2xYFXESqvPU0AciZ1bZaDNyhSNpfqnF-gpZ5-.jpg?size=200x200&quality=96&crop=121,0,360,360&ava=1",
                        date = "02.02.2023"
                    )
                )
            } else{
                add(
                    Chats(
                        name = "Zhasik",
                        demoText = "Ya chert!!!",
                        avatarUrl = "https://www.meme-arsenal.com/memes/ec1dfa6ef836050d28387bd0cf451305.jpg",
                        date = "02.02.2023"
                    )
                )
            }
        }
    }

}