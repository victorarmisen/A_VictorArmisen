package com.example.a_victorarmisen.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a_victorarmisen.R
import com.example.a_victorarmisen.model.GamesResponse
import com.example.a_victorarmisen.model.TWStream
import com.example.a_victorarmisen.model.TWStreamsResponse
import com.example.a_victorarmisen.network.TwitchApiService
import okhttp3.Call
import okhttp3.Response
import okhttp3.ResponseBody
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
        TwitchApiService.endpoints.getStreams().enqueue(object : retrofit2.Callback<TWStreamsResponse> {

            override fun onResponse(call: retrofit2.Call<TWStreamsResponse>, response: retrofit2.Response<TWStreamsResponse>) {
                Log.i("StreamsFragment", "++ onResponse ++")
                if (response.isSuccessful()) {
                    Log.i("StreamFragment", response.body()?.toString() ?: "Null body")
                    val streams = response.body()?.data
                    streams?.forEach {
                        //Get games
                        it.gameId?.let { gameId ->
                            TwitchApiService.endpoints.getGames(gameId).enqueue(object : retrofit2.Callback<GamesResponse>
                            {
                                override fun onFailure(call: retrofit2.Call<GamesResponse>, t: Throwable) {
                                    Log.w("StreamsFragment",t)
                                }

                                override fun onResponse(call: retrofit2.Call<GamesResponse>, response: retrofit2.Response<GamesResponse>) {
                                    if(response.isSuccessful()) {
                                        val games = response.body()?.data
                                        streams?.forEach { stream->
                                            games?.forEach { game->
                                                if(stream.gameId == game.id){
                                                    stream.game = game
                                                }
                                            }

                                        }
                                        Log.i("StreamsFragment", "Got games $games")
                                        Log.i("StreamsFragment", "Got streams with games $streams")
                                    } else {
                                        Log.w("StreamsFragment", "Error getting games")
                                    }

                                }

                            })
                        }

                    }

                }
                /*
                response.body()?.data?.let { streams ->
                    for (stream in streams) {
                        Log.i("MainActivity", "Title: ${stream.title} and image: ${stream.imageUrl} and username: ${stream.username}")
                        Log.i("MainActivity", "Stream Url: https://www.twitch.tv/${stream.username}")
                    }
                }
                */

            }

            override fun onFailure(call: retrofit2.Call<TWStreamsResponse>, t: Throwable) {
                t.printStackTrace()
            }

        })

    }
}



