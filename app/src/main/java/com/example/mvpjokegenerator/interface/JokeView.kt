package com.example.mvpjokegenerator.`interface`

import com.example.mvpjokegenerator.model.Joke

interface JokeView {

    fun showJoke(joke: Joke)
    fun showJokeList(joke: List<Joke>)
}