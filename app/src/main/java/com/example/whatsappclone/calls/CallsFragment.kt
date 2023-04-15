package com.example.whatsappclone.calls

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R
import com.example.whatsappclone.calls.adapter.CallsRecyclerAdapter
import com.example.whatsappclone.calls.addChat.ChatCreateActivity
import com.example.whatsappclone.chats.ChatRecyclerAdapter
import com.example.whatsappclone.chats.ChatViewModel
import com.example.whatsappclone.chats.detail.ChatDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class CallsFragment: Fragment(R.layout.fragment_calls) {

    private val viewModel by viewModel<CallsViewModel>()
    lateinit var recyclerView: RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewCreated()
        setupView(view)
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onViewCreated()
    }

    private fun setupView(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        val addGroupView = view.findViewById<RelativeLayout>(R.id.addGroupViewGroup)

        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        addGroupView.setOnClickListener {
            val intent = Intent(activity, ChatCreateActivity::class.java)
            startActivity(intent)
        }
    }

    private fun observeViewModel() = with(viewModel){
        callsData.observe(viewLifecycleOwner) { groupList ->
            recyclerView.adapter = CallsRecyclerAdapter(
                item = groupList,
                onItemClickListener = { chat ->

                }
            )
        }
    }
}