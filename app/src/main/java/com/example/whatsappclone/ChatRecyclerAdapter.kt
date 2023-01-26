package com.example.whatsappclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatRecyclerAdapter(
    private val item: List<String>
) : RecyclerView.Adapter<ChatRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_chat, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        lateinit var nameTextView: TextView

        fun bind(item: String){
            nameTextView = itemView.findViewById(R.id.nameTextView)
            nameTextView.text = item
        }
    }
}