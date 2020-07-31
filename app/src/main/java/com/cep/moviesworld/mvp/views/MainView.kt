package com.cep.moviesworld.mvp.views

interface MainView : BaseView{

    fun getPopularFilmsAndSerials()
    fun getCategories()
    fun getMoviesByCategory()
    fun getShowcases()
    fun getBestActors()

    fun navigateToMovieDetails()
}