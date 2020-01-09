package com.example.a_victorarmisen.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a_victorarmisen.R
import com.example.a_victorarmisen.network.TwitchApiService
import okhttp3.Call
import okhttp3.Response
import java.io.IOException
import javax.security.auth.callback.Callback

class StreamsFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_streams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Code

        //TwitchApiService.endpoints.getStreams();
        TwitchApiService.endpoints.getStreams().enqueue(object : okhttp3.Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                Log.i("StreamsFragment", "++ onResponse ++ ")
                if(response.code() == 200) {
                    //All good
                    Log.i("StreamsFragment", response.body()?.string() ?: "Null body")
                } else {
                    //Problem
                    Log.w("StreamsFragment", response.message())
                }
                response.body()
            }


        })
    }

}


