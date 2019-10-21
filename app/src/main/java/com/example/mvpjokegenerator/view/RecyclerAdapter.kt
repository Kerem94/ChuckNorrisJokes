package com.example.mvpjokegenerator.view


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpjokegenerator.model.Joke


class RecyclerAdapter (private val list: List<Joke>)
    : RecyclerView.Adapter<JokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return JokeViewHolder(inflater,parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke: Joke = list[position]
        holder.bind(joke)
    }
}