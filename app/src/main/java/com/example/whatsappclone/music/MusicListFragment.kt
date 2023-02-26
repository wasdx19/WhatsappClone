package com.example.whatsappclone.music

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R
import com.example.whatsappclone.music.adapter.MusicListRecyclerAdapter
import com.example.whatsappclone.music.detail.MusicDetailActivity
import kotlinx.android.parcel.Parcelize

class MusicListFragment: Fragment(R.layout.fragment_music) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = MusicListRecyclerAdapter(
            item = getMusicSampleData(),
            onItemClickListener = { music ->
                val intent = Intent(activity, MusicDetailActivity::class.java)
                intent.putExtra("ARG_MUSIC", music)
                startActivity(intent)
            }
        )
    }


    private fun getMusicSampleData() = mutableListOf<Music>().apply {
        add(
            Music(
                musicName = "Azamat Dosm Good",
                artistName = "Azamat",
                time = "00:05",
                labelImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/Freddie_Mercury_performing_in_New_Haven%2C_CT%2C_November_1977.jpg/1200px-Freddie_Mercury_performing_in_New_Haven%2C_CT%2C_November_1977.jpg"
            )
        )
        add(
            Music(
                musicName = "Azamat Dosm Good",
                artistName = "Azamat",
                time = "00:05",
                labelImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/Freddie_Mercury_performing_in_New_Haven%2C_CT%2C_November_1977.jpg/1200px-Freddie_Mercury_performing_in_New_Haven%2C_CT%2C_November_1977.jpg"
            )
        )
        add(
            Music(
                musicName = "Azamat Dosm Good",
                artistName = "Azamat",
                time = "00:05",
                labelImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/Freddie_Mercury_performing_in_New_Haven%2C_CT%2C_November_1977.jpg/1200px-Freddie_Mercury_performing_in_New_Haven%2C_CT%2C_November_1977.jpg"
            )
        )
    }
}

@Parcelize
data class Music(
    val musicName: String,
    val artistName: String,
    val time: String,
    val labelImage: String
): Parcelable