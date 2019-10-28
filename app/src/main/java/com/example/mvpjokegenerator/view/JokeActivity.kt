package com.example.mvpjokegenerator.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpjokegenerator.R

class JokeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jokeMainMenuFragment = JokeFragment()
        supportFragmentManager.beginTransaction().add(
            R.id.fragment_container, jokeMainMenuFragment).commit()
    }


}
