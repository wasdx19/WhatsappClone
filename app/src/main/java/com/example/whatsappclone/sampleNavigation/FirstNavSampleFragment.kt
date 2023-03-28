package com.example.whatsappclone.sampleNavigation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.whatsappclone.R

class FirstNavSampleFragment: Fragment(R.layout.fragment_first_nav_sample) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonView = view.findViewById<Button>(R.id.buttonView)

        buttonView.setOnClickListener {
            findNavController().navigate(R.id.from_first_to_second_fragment)
        }
    }
}