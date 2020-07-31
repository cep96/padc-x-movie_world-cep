package com.cep.moviesworld.mvp.presenters

import com.cep.moviesworld.mvp.views.BaseView

interface BasePresenter<T: BaseView> {

    fun initPresenter(view: T)
}