package com.example.a_victorarmisen.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a_victorarmisen.R
import com.example.a_victorarmisen.model.NewsModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*
import kotlinx.android.synthetic.main.item_stream.view.*

class NewsAdapter(var list: ArrayList<NewsModel>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        //..
        val newTitle = itemView.title_news
        val newImage = itemView.image_news
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        //holder.button.text = list[position]
        val news = list[position]

        holder.newTitle.text = news.title_news
        //Picasso.get().load(news.image_news).into(holder.newImage)
        holder.newImage.setImageURI(Uri.parse(news.image_news))


    }


}