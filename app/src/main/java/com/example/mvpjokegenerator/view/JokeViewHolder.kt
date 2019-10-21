package com.example.mvpjokegenerator.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpjokegenerator.R
import com.example.mvpjokegenerator.model.Joke

class JokeViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.recyclerview_items, parent, false)) {

    private var tvId: TextView? = null
    private var tvJoke: TextView? = null
    private var category: TextView? = null

    init {
        tvId = itemView.findViewById(R.id.tvId)
        tvJoke = itemView.findViewById(R.id.tvJoke)
        category = itemView.findViewById(R.id.tvCategory)
    }

    fun bind(joke: Joke){
        tvJoke?.text = joke.text
    }



}