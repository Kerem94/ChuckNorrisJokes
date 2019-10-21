package com.example.mvpjokegenerator.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.mvpjokegenerator.R
import com.example.mvpjokegenerator.`interface`.JokeView
import com.example.mvpjokegenerator.model.Joke
import com.example.mvpjokegenerator.model.Repository
import com.example.mvpjokegenerator.presenter.Presenter
import kotlinx.android.synthetic.main.fragment_jokelist.*

class JokeListFragment : Fragment(), JokeView {
    override fun showJoke(joke: Joke) {
    }

    private lateinit var presenter: Presenter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_jokelist, container, false)
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = Presenter(Repository(), this)

        presenter.getJokeList()

    }

    override fun showJokeList(joke: List<Joke>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerAdapter(joke)
        }
    }


}