package com.example.mvpjokegenerator.model

import android.nfc.Tag
import android.util.Log
import com.example.mvpjokegenerator.`interface`.JokeService
import com.example.mvpjokegenerator.`interface`.JokeRepository
import com.google.gson.GsonBuilder
import okhttp3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository : JokeRepository {


    val URL = "https://api.icndb.com/"
    val gson = GsonBuilder().create()
    lateinit var jokeCallback: JokeCallBack
    private val retrofitClient by lazy { createRetrofitClient() }

    override fun getJoke() {
       val jokeService = retrofitClient.create(JokeService::class.java)
        val callback = jokeService.getRandomJoke()
        callback.enqueue(object : Callback<Joke> {
            override fun onFailure(call: Call<Joke>, t: Throwable) {
            }

            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                response.body()?.let {joke ->
                    val jokeText = joke.text
                    val jokeId = joke.id
                    val jokeCategory = joke.categories
                    jokeCallback.onJokeReceived(Joke(jokeText,jokeId,jokeCategory))
                }

            }

        })
    }

    override fun getJokeList() {
        val jokeService = retrofitClient.create(JokeService::class.java)
        val callback = jokeService.getListOfJokes()
        callback.enqueue(object : Callback<JokeAPIResponse>{
            override fun onFailure(call: Call<JokeAPIResponse>, t: Throwable) {
                Log.e("repository","Error")
            }

            override fun onResponse(
                call: Call<JokeAPIResponse>,
                response: Response<JokeAPIResponse>
            ) {
                response.body()?.let {

                    //jokeCallback.onJokeListRecieved()
                }
            }

        })

    }



    private fun createRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .client(OkHttpClient())
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    interface JokeCallBack {
        fun onJokeReceived(joke: Joke)
        fun onJokeListRecieved(jokeList: List<Joke>)
    }

}
