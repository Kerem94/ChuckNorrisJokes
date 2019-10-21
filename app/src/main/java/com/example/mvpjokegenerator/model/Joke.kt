package com.example.mvpjokegenerator.model

import com.google.gson.annotations.SerializedName

data class Joke (
    @SerializedName("joke")
    val text: String,
    @SerializedName("id")
    val id : Int,
    @SerializedName("categories")
    val categories : MutableList<String>
)

