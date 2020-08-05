package com.cep.moviesworld.mvp.views

import com.cep.moviesworld.data.vos.ResultsVO

interface MovieByCategoryView: BaseView {

    fun displayMoviesByGenre(movies: List<ResultsVO>)

    fun navigateToMovieDetails(movieId: Int)
}