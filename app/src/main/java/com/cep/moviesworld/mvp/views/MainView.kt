package com.cep.moviesworld.mvp.views

interface MainView : BaseView{

    fun displayPopularFilmsAndSerials(popularFilmsAndSerials: List<String>)
    fun displayShowcases(showcases: List<String>)
    fun displayBestActors(actors: List<String>)

    fun navigateToMovieDetails(movieId: Int)
}