package com.example.whatsappclone

import android.os.Bundle
import android.view.View
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

    private fun getChatSampleData() = mutableListOf<String>().apply {
        (0..20).forEach {index ->
            add("$index Bill Gates")
        }
    }
}