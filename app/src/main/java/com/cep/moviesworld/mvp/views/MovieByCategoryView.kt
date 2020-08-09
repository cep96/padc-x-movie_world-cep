package com.cep.moviesworld.mvp.views

import com.cep.moviesworld.data.vos.ResultsVO
import com.cep.shared.BaseView

interface MovieByCategoryView: BaseView {

    fun displayMoviesByGenre(movies: List<ResultsVO>)

    fun navigateToMovieDetails(movieId: Int)
}