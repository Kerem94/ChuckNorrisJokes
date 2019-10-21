package com.example.mvpjokegenerator.presenter

import com.example.mvpjokegenerator.`interface`.JokeView
import com.example.mvpjokegenerator.model.Joke
import com.example.mvpjokegenerator.model.Repository
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class PresenterTest {
    private val view = mockk<JokeView>(relaxed = true)
    private val repository = mockk<Repository>(relaxed = true)
    private val mockJoke = mockk<Joke>(relaxed = true)
    private val jokePresenter = Presenter(repository, view)

    @Test
    fun testGetJoke() {
        //when
        jokePresenter.getJoke()

        //then
        verify {
            repository.getJoke()
        }
    }

    @Test
    fun recieveJoke(){
        //when
        jokePresenter.onJokeReceived(mockJoke)

        //then
        verify { view.showJoke(mockJoke) }
    }


}