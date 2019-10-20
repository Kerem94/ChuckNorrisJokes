package com.example.mvpjokegenerator.Interface

interface Presenter {

    fun onViewCreated()
    fun setJoke() : String
    fun getJoke()
}