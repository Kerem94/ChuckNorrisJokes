package com.example.mvpjokegenerator.`interface`

import androidx.fragment.app.Fragment
import com.example.mvpjokegenerator.model.Joke

interface JokePresenter {

    fun getJokeList()
    fun getJoke()
    fun changeFragment(fragment: Fragment)
}