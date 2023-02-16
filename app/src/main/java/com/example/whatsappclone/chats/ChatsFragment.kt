package com.example.whatsappclone

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.chats.ChatRecyclerAdapter
import com.example.whatsappclone.chats.detail.ChatDetailActivity
import kotlinx.parcelize.Parcelize

class ChatsFragment: Fragment(R.layout.fragment_chats) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = ChatRecyclerAdapter(
            item = getChatSampleData(),
            onItemClickListener = { chat ->
                val intent = Intent(activity, ChatDetailActivity::class.java)
                intent.putExtra("ARG_CHAT", chat)
                startActivity(intent)
            }
        )
    }

    private fun getChatSampleData() = mutableListOf<Chats>().apply {
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


@Parcelize
data class Chats(
    val name: String,
    val demoText: String,
    val avatarUrl: String,
    val date: String
): Parcelable