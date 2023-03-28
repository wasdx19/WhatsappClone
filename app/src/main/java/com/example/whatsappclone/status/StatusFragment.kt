package com.example.whatsappclone.status

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.whatsappclone.R
import com.example.whatsappclone.sampleNavigation.NavigationSampleActivity

class StatusFragment: Fragment(R.layout.fragment_status) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.titleTextView)

        textView.setOnClickListener {
            val intent = Intent(activity, NavigationSampleActivity::class.java)
            startActivity(intent)
        }
    }
}