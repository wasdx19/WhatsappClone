package com.example.whatsappclone

import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatsFragment: Fragment(R.layout.fragment_chats) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = ChatRecyclerAdapter(getChatSampleData())
    }

    private fun getChatSampleData() = mutableListOf<Chats>().apply {
        (0..20).forEach {index ->
            if(index%2 == 0) {
                add(
                    Chats(
                        name = "Ansar",
                        demoText = "Hello everyone!!!",
                        avatar = R.drawable.ic_person,
                        date = "02.02.2023"
                    )
                )
            } else if(index%3 == 0){
                add(
                    Chats(
                        name = "Kaira",
                        demoText = "Ans Ans!!!",
                        avatar = R.drawable.ic_default,
                        date = "02.02.2023"
                    )
                )
            } else{
                add(
                    Chats(
                        name = "Zhasik",
                        demoText = "Ya chert!!!",
                        avatar = R.drawable.ic_default,
                        date = "02.02.2023"
                    )
                )
            }
        }
    }
}

data class Chats(
    val name: String,
    val demoText: String,
    @DrawableRes val avatar: Int,
    val date: String
)