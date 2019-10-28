package com.example.mvpjokegenerator.presenter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.mvpjokegenerator.R
import com.example.mvpjokegenerator.`interface`.JokePresenter
import com.example.mvpjokegenerator.`interface`.JokeView
import com.example.mvpjokegenerator.model.Joke
import com.example.mvpjokegenerator.model.Repository

class Presenter(private val repository: Repository, private val jokeView: JokeView) : JokePresenter,
    Repository.JokeCallBack {

    companion object FragmentTransaction


    init {
        repository.jokeCallback = this
    }

    override fun onJokeListRecieved(jokeList: List<Joke>) {
        jokeView.showJokeList(jokeList)
    }

    override fun getJokeList() {
        repository.getJokeList()
    }

    override fun getJoke() {
        repository.getJoke()
    }

    override fun onJokeReceived(joke: Joke) {
        jokeView.showJoke(joke)
    }

    override fun changeFragment(fragment: Fragment){

    }



}