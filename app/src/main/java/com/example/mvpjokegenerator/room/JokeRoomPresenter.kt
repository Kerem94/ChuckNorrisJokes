package com.example.mvpjokegenerator.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mvpjokegenerator.model.Joke
import kotlinx.coroutines.launch


class JokeRoomPresenter(application: Application) : AndroidViewModel(application) {

    private val repository: JokeRepository

    val allJokes: LiveData<List<Joke>>

    init {
        val jokeDao = JokeRoomDatabase.getDatabase(application).jokeDao()
        repository = JokeRepository(jokeDao)
        allJokes = repository.allJokes
    }

    fun insert(joke: Joke) = viewModelScope.launch {
        repository.insert(joke)
    }
}