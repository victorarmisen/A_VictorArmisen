package com.example.a_victorarmisen.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a_victorarmisen.R
import com.example.a_victorarmisen.adapter.NewsAdapter
import com.example.a_victorarmisen.adapter.StreamsAdapter
import com.example.a_victorarmisen.model.ChatMessage
import com.example.a_victorarmisen.model.NewsModel
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_streams.*


/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        return view;


/*
        FirebaseFirestore.getInstance()
                .collection("chat")
                .addSnapshotListener { newQuerySnapshot, firebaseFirestoreException ->
                    //New message added
                    //val messages = newQuerySnapshot?.toObjects(ChatMessage::class.java) ?: emptyList()
                    //adapter pasar lista de mensaje.

                    val messages = newQuerySnapshot?.toObjects(NewsModel::class.java) ?: emptyList()
                    Picasso.get().load(messages).into(image);
                    //Picasso.get().load(messages.get("imageURL").toString()).into(image);
                    //titulo.setText(messages.get("titulo1").toString())
                    //adapter.list = messages
                    adapter.notifyDataSetChanged()
                    //Log.i("ChatFragment", messages.toString())
                }



*/
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val image =  view.findViewById(R.id.image_url) as ImageView
        //val titulo = view.findViewById(R.id.titulo1) as TextView

        //Code
        val adapter = NewsAdapter(ArrayList())
        recyclerviewNews.layoutManager = LinearLayoutManager(requireContext())
        recyclerviewNews.adapter = adapter

        val db = FirebaseFirestore.getInstance()



        db.collection("news_").get().addOnSuccessListener { documents->
            for (document in documents) {
                //Log.i("NewsFragment", document.id);
                val messages = document.toObject(NewsModel::class.java)
                Log.i("NewsFragment", messages.toString());
                adapter.list.add(NewsModel(messages.title_news,messages.image_news))
                adapter.notifyDataSetChanged()
            }
        }


    }








}
