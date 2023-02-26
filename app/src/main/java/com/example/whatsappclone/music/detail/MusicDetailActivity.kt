package com.example.whatsappclone.music.detail

import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.whatsappclone.R
import com.example.whatsappclone.music.Music
import com.example.whatsappclone.service.MusicPlayerService

class MusicDetailActivity: AppCompatActivity() {

    private var musicData: Music? = null
    var isPlayClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player)
        musicData = intent.getParcelableExtra<Music>("ARG_MUSIC")
        setupView()
    }

    private fun setupView() {
        val musicName = findViewById<TextView>(R.id.musicName)
        val labelImage = findViewById<AppCompatImageView>(R.id.labelImageView)
        val playButton = findViewById<RelativeLayout>(R.id.playButton)
        val playButtonImage = findViewById<AppCompatImageView>(R.id.playImageView)

        musicData?.let {
            Glide
                .with(this)
                .load(it.labelImage)
                .centerCrop()
                .placeholder(R.drawable.ic_default)
                .into(labelImage)

            musicName.text = it.musicName
        }

        val intent = Intent(this, MusicPlayerService::class.java)

        playButton.setOnClickListener {
            isPlayClicked = !isPlayClicked
            if(isPlayClicked){
                playButtonImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_pause))
                startService(intent)
            }else{
                playButtonImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_play))
                stopService(intent)
            }
        }
    }
}