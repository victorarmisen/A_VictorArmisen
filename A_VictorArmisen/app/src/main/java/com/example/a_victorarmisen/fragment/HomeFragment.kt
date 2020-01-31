package com.example.a_victorarmisen.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a_victorarmisen.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newURL = "https://www.tilt.fi/wp-content/uploads/2019/03/hunt.jpg"
        //Log.i("StreamsFragment", newURL.toString())
        //holder.imThumb.setImageURI(Uri.parse(newURL))
        Picasso.get().load(newURL).into(image_presentation)

    }


}
