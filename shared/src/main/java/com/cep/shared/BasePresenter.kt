package com.cep.shared

interface BasePresenter<T: BaseView>{

    fun initPresenter(view: T)
}