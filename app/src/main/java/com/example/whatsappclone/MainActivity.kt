package com.example.whatsappclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.whatsappclone.network.AnimeListDTO
import com.example.whatsappclone.network.ApiServices
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 *  Whatsapp clone
 *  1. Create XML design for main page
 *  2. Create fragments for each tab
 *  3. Create PagerAdapter
 *  4. Create XML for each fragment
 *  5. RecyclerView item
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        viewPager.adapter = PagerAdapter(lifecycle, supportFragmentManager)

        TabLayoutMediator(
            tabLayout,
            viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when(position){
                    0 -> tab.text = "Chats"
                    1 -> tab.text = "Status"
                    2 -> tab.text = "Calls"
                    3 -> tab.text = "Music"
                }
            }
        ).attach()
    }
}


/***
 *  1. Загрузить библио
 *  2. Создать ApiClient
 *  3. Cоздать ApiServices
 *  4. Создаем DTO классы зависимо от response
 *  5. Внутри активити/фрагмент делаем вызов запроса
 *  6. Обрабатываем полученный ответ
 */