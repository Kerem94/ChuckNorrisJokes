package com.example.mvpjokegenerator.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mvpjokegenerator.R
import com.example.mvpjokegenerator.`interface`.JokeView
import com.example.mvpjokegenerator.model.Joke
import com.example.mvpjokegenerator.model.Repository
import com.example.mvpjokegenerator.presenter.Presenter
import kotlinx.android.synthetic.main.fragment_joke.*

class JokeFragment : Fragment(), JokeView {
    override fun showJokeList(joke: List<Joke>) {
    }


    private lateinit var presenter: Presenter



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = Presenter(Repository(), this)
        nextBtn.setOnClickListener { (presenter?.getJoke()) }
    }


    override fun showJoke(joke: Joke) {
        requireActivity().runOnUiThread {
            factTv.text = joke.text
        }
    }
}
