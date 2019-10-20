package com.example.mvpjokegenerator.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpjokegenerator.Interface.View
import com.example.mvpjokegenerator.Presenter.MainPresenter
import com.example.mvpjokegenerator.R
import kotlinx.android.synthetic.main.activity_main.*

class MainView : AppCompatActivity(), View {


    private var presenter: MainPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        presenter = MainPresenter(this)
    }

    override fun initView() {

        nextBtn.setOnClickListener { (presenter?.getJoke()) }

    }

    override fun loadRandomFact() {
        factTv.text = presenter?.setJoke()
    }
}
