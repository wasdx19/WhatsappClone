package com.example.whatsappclone.chats.detail

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.example.whatsappclone.chats.Chats
import com.example.whatsappclone.R
import com.example.whatsappclone.broadcastReceivers.BroadcastConstants.DYNAMIC_BROADCAST
import com.example.whatsappclone.broadcastReceivers.DynamicBroadcastReceiver


class ChatDetailActivity: AppCompatActivity() {

    var chat: Chats? = null

    private val dynamicBroadcastReceiver = DynamicBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_detail)

        chat = intent.getParcelableExtra<Chats>("ARG_CHAT") as Chats
        setupView()

        registerDynamicBroadCast()
    }

    private fun registerDynamicBroadCast() {
        val filter = IntentFilter(DYNAMIC_BROADCAST)
        this.registerReceiver(dynamicBroadcastReceiver, filter)
    }

    private fun setupView() {
        val textView = findViewById<TextView>(R.id.textview)
        val dynamicButton = findViewById<Button>(R.id.dynamicButton)
        val staticButton = findViewById<Button>(R.id.staticButton)
        val backIconView = findViewById<AppCompatImageView>(R.id.backIconView)

        val greeting = if(chat?.name.equals("Kaira")) "Hitler" else chat?.name
        textView.text = "Hi $greeting"

        backIconView.setOnClickListener {
            finish()
        }

        dynamicButton.setOnClickListener {
//            val intent = Intent()
//            intent.action = DYNAMIC_BROADCAST
//            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
//            sendBroadcast(intent)
        }

        staticButton.setOnClickListener {
//            val intent = Intent()
//            intent.action = STATIC_BROADCAST
//            sendBroadcast(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(dynamicBroadcastReceiver)
    }
}