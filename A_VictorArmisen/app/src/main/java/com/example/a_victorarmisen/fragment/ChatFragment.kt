package com.example.a_victorarmisen.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a_victorarmisen.R
import com.example.a_victorarmisen.adapter.ChatAdapter
import com.example.a_victorarmisen.model.ChatMessage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.item_chat.*

class ChatFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    private val adapter = ChatAdapter(emptyList())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sendButtonChat.setOnClickListener {
            sendMessage(text_send.text.toString())
        }


        recyclerviewChat.layoutManager = LinearLayoutManager(requireContext())
        recyclerviewChat.adapter = adapter

        getMessages()

    }

    private fun getMessages() {

        FirebaseFirestore.getInstance()
                .collection("chat")
                .get()
                .addOnSuccessListener {
                    val messages = it.toObjects(ChatMessage::class.java)
                    //adapter pasar lista de mensaje.
                    adapter.list = messages
                    adapter.notifyDataSetChanged()
                    Log.i("ChatFragment", messages[3].text.toString())
                }
                .addOnFailureListener {

                }

    }

    private fun sendMessage(text: String) {

        val message = ChatMessage(text = text, timestamp = System.currentTimeMillis(), userId = FirebaseAuth.getInstance()
                .currentUser?.uid)
        FirebaseFirestore.getInstance()
                .collection("chat")
                .add(message)
                .addOnSuccessListener {
                    getMessages()
                }
                .addOnFailureListener {

                }

    }



}