package com.example.a_victorarmisen.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a_victorarmisen.R
import com.example.a_victorarmisen.activity.StreamsDetailActivity
import com.example.a_victorarmisen.model.StreamModel
import kotlinx.android.synthetic.main.item_stream.view.*

class StreamsAdapter(var list: ArrayList<StreamModel>) : RecyclerView.Adapter<StreamsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val button = itemView.button_Stream
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_stream, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stream = list[position]
        holder.button.text = list[position].game?.name

        holder.itemView.setOnClickListener {

            val intent = Intent(holder.button.context, StreamsDetailActivity::class.java)
            intent.putExtra("streamId", stream.id)
            intent.putExtra("stream", stream.userId)
            holder.button.context.startActivity(intent)

        }



    }
}