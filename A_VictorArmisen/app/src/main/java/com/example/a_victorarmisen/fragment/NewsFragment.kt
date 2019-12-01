package com.example.a_victorarmisen.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.a_victorarmisen.R
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso


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


        val image =  view.findViewById(R.id.image_url) as ImageView
        val titulo = view.findViewById(R.id.titulo1) as TextView


        val db = FirebaseFirestore.getInstance()

        val docRef = db.collection("news_").document("NEWS_ID")
        docRef.get()
            .addOnSuccessListener { document ->

                if (document != null)
                {
                    //image.set(document.get("imageURL"))
                    Picasso.get().load(document.get("imageURL").toString()).into(image);
                    titulo.setText(document.get("titulo1").toString())

                } else {
                    //Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                //Log.d(TAG, "get failed with ", exception)
            }



        return view;
    }







}
