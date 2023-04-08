package com.example.whatsappclone.sampleNavigation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.whatsappclone.R
import com.example.whatsappclone.chats.ChatViewModel
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstNavSampleFragment: Fragment(R.layout.fragment_first_nav_sample) {

    private val viewModel by viewModel<FirstNavViewModel>()

    private lateinit var progressBar: RelativeLayout
    private lateinit var textView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        viewModel.onViewCreated()
        setupView(view)
    }

    private fun setupView(view: View){
        progressBar = view.findViewById(R.id.progressBar)
        textView = view.findViewById(R.id.textView)
        val buttonView = view.findViewById<Button>(R.id.buttonView)

        buttonView?.setOnClickListener {
            findNavController().navigate(R.id.from_first_to_second_fragment)
        }
    }

    private fun observeViewModel() = with(viewModel){
        showLoader.observe(viewLifecycleOwner){
            progressBar.isVisible = it
        }

        message.observe(viewLifecycleOwner){
            textView.text = it
        }
    }

    private suspend fun download(fileName: String, loadTime: Long){
        delay(loadTime)
        Log.d("Corountines_Sample", "$fileName downloaded" )
    }
}