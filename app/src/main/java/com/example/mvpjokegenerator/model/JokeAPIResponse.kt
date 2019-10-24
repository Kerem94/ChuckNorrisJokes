package com.example.mvpjokegenerator.model

import com.google.gson.annotations.SerializedName

data class JokeAPIResponse (
    @SerializedName("type")
    val type: String,

    @SerializedName("value")
    val jokes : MutableList<Joke>
)