package com.example.mvpjokegenerator.room

import androidx.lifecycle.LiveData
import com.example.mvpjokegenerator.model.Joke

class JokeRepository (private val jokeDao: JokeDao){

    val allJokes: LiveData<List<Joke>> = jokeDao.getAplhabetizedWords()

    suspend fun insert(joke: Joke){
        jokeDao.insert(joke)
    }
}