package com.example.whatsappclone.chats

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R
import com.example.whatsappclone.chats.detail.ChatDetailActivity
import com.example.whatsappclone.network.ApiServices
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatsFragment: Fragment(R.layout.fragment_chats) {

    private val viewModel by viewModel<ChatViewModel>()

    lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: RelativeLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        observeViewModel()
        viewModel.onViewCreated()
    }

    private fun setupView(view: View){
        progressBar = view.findViewById(R.id.progressBar)
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun observeViewModel() = with(viewModel){
        showLoader.observe(viewLifecycleOwner){
            progressBar.isVisible = it
        }
        basketDetailData.observe(viewLifecycleOwner){ animeList ->
            recyclerView.adapter = ChatRecyclerAdapter(
                item = animeList,
                onItemClickListener = { chat ->
                    val intent = Intent(activity, ChatDetailActivity::class.java)
                    intent.putExtra("ARG_CHAT", chat)
                    startActivity(intent)
                }
            )
        }
    }
}