package com.example.mvpjokegenerator.`interface`

import com.example.mvpjokegenerator.model.Joke
import com.example.mvpjokegenerator.model.JokeAPIResponse
import retrofit2.Call
import retrofit2.http.GET

interface JokeService {

    @GET("jokes/random")
    fun getRandomJoke(): Call<Joke>

    @GET("jokes")
    fun getListOfJokes(): Call<JokeAPIResponse>

}