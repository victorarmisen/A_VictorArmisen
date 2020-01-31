package com.example.a_victorarmisen.adapter

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a_victorarmisen.R
import com.example.a_victorarmisen.activity.MainActivity
import com.example.a_victorarmisen.activity.StreamsDetailActivity
import com.example.a_victorarmisen.model.TWStream
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_stream.view.*

class StreamsAdapter(var list: ArrayList<TWStream>) : RecyclerView.Adapter<StreamsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val button = itemView.button_Stream
        val imThumb = itemView.imageThumb
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_stream, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int
    {
        return list.count()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val stream = list[position]
        holder.button.text = list[position].username
        Log.i("StreamsAdapter", "Hello")

        holder.button.setOnClickListener {

        val intent = Intent(holder.button.context, StreamsDetailActivity::class.java)

        intent.putExtra("name_stream", stream.username)
        intent.putExtra("game_stream", stream.game?.name)
        intent.putExtra("video_stream", stream.video?.url)
        intent.putExtra("viewcount_stream", stream.tagMain?.description)

        Log.i("StreamsAdapter", "Hello")
        Log.i("StreamsFragment", "STREAM VIDEO NAME: " + stream.video)
        Log.i("StreamsFragment", "STREAM GAME NAME: " + stream.game)
        Log.i("StreamsFragment", "STREAM TAGS NAME: " + stream.tagMain)

        holder.button.context.startActivity(intent)

        }

        val newURL = stream.thumbnailUrl?.replace("{width}","300")?.replace("{height}","300")
        Log.i("StreamsFragment", newURL.toString())
        //holder.imThumb.setImageURI(Uri.parse(newURL))
        Picasso.get().load(newURL).into(holder.imThumb)



    }
}