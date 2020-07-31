package com.cep.moviesworld.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.cep.moviesworld.mvp.views.MovieByCategoryView

class MoviesByCategoryPresenterImpl: MoviesByCategoryPresenter,
    AbstractBasePresenter<MovieByCategoryView>() {

    private val strArray: List<String> = arrayListOf()

    override fun onUIReadyMovies(lifecycleOwner: LifecycleOwner) {
        mView?.displayMoviesByCategory(strArray)
    }
}