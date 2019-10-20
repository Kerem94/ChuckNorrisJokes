package com.example.mvpjokegenerator.Presenter

import com.example.mvpjokegenerator.Interface.Model
import com.example.mvpjokegenerator.Interface.Presenter
import com.example.mvpjokegenerator.Interface.View
import com.example.mvpjokegenerator.Model.MainModel
import com.example.mvpjokegenerator.View.MainView

class MainPresenter (mainView: MainView) : Presenter {

    private var view: View = mainView
    private  var model: Model = MainModel()

    init{
        view.initView()
    }

    override fun onViewCreated() {
        view.loadRandomFact()
    }

    override fun getJoke() {
        model.getJoke()
        view.loadRandomFact()
    }

    override fun setJoke() = model.setJoke()

}