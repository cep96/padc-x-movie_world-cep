package com.cep.moviesworld.mvp.views

interface MovieByCategoryView: BaseView {

    fun displayMoviesByCategory(movies: List<String>)

    fun navigateToMovieDetails(movieId: Int)
}