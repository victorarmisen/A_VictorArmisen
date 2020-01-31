package com.example.a_victorarmisen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a_victorarmisen.R
import com.example.a_victorarmisen.model.ChatMessage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_chat.view.*

class ChatAdapter(var list: List<ChatMessage>) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        //..
        val textChat = itemView.textChatUser
        val textUsername = itemView.textUsernameChat
        val textTime = itemView.textTimeChat
        val avatar = itemView.Image_Avatar

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ChatAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ChatAdapter.ViewHolder, position: Int) {
            holder.textChat.text = "New message " + "from " + list[position].username + ": "
            holder.textUsername.text = list[position].text
            holder.textTime.text = "Time: " + list[position].timestamp.toString()
            val URL_LOGO = "https://i.redd.it/fldyql8i8n931.png"
            Picasso.get().load(URL_LOGO).into(holder.avatar)
    }




}