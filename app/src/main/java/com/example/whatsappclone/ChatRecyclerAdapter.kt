package com.example.whatsappclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ChatRecyclerAdapter(
    private val item: List<Chats>
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
        lateinit var msgTextView: TextView
        lateinit var avatarView: AppCompatImageView
        lateinit var dateTextView: TextView

        fun bind(item: Chats){
            nameTextView = itemView.findViewById(R.id.nameTextView)
            msgTextView = itemView.findViewById(R.id.msgTextView)
            avatarView = itemView.findViewById(R.id.avatarView)
            dateTextView = itemView.findViewById(R.id.dateTextView)

            nameTextView.text = item.name
            msgTextView.text = item.demoText
            dateTextView.text = item.date

            avatarView.setImageDrawable(
                ContextCompat.getDrawable(itemView.context, item.avatar)
            )
        }
    }
}