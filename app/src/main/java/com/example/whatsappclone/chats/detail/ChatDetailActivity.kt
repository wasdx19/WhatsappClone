package com.example.whatsappclone.chats.detail

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.whatsappclone.R

class ChatDetailActivity: AppCompatActivity() {

    var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_detail)

        name = intent.getStringExtra("ARG_NAME")
        setupView()
    }

    private fun setupView() {
        val textView = findViewById<TextView>(R.id.textview)
        val greeting = if(name.equals("Kaira")) "Hitler" else name
        textView.text = "Hi $greeting"
    }
}