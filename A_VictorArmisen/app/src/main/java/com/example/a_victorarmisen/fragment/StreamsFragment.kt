package com.example.a_victorarmisen.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a_victorarmisen.R
import com.example.a_victorarmisen.adapter.StreamsAdapter
import com.example.a_victorarmisen.model.*
import com.example.a_victorarmisen.network.TwitchApiService
import kotlinx.android.synthetic.main.fragment_streams.*

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
        val adapter = StreamsAdapter(ArrayList())
        recyclerview.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerview.adapter = adapter


        //TwitchApiService.endpoints.getStreams();
        TwitchApiService.endpoints.getStreams().enqueue(object : retrofit2.Callback<TWStreamResponse> {
            override fun onFailure(call: retrofit2.Call<TWStreamResponse>, t: Throwable) {

                    t.printStackTrace()

            }

            override fun onResponse(call: retrofit2.Call<TWStreamResponse>, response: retrofit2.Response<TWStreamResponse>) {
                response.body()?.data?.let { streams ->
                    for (stream in streams) {

                        adapter.list.add(stream?.title.toString())



                        Log.i("MainActivity", "Title: ${stream.title} and image: ${stream.thumbnailUrl} and username: ${stream.username}")
                        Log.i("MainActivity", "Stream Url: https://www.twitch.tv/${stream.username}")
                    }

                    adapter.notifyDataSetChanged()


                }
            }
            /*
            override fun onResponse(call: retrofit2.Call<TWStreamsResponse>, response: retrofit2.Response<TWStreamsResponse>) {

                Log.i("StreamsFragment", "++ onResponse ++")

                if (response.isSuccessful()) {

                    Log.i("StreamFragment", response.body()?.toString() ?: "Null body")

                    //Get games of the streams
                    val streams = response.body()?.data
                    //For each to get them
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


                                        adapter.list.add(games?.firstOrNull()?.name ?: "")
                                        adapter.notifyDataSetChanged()


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

        */








})

}



}



