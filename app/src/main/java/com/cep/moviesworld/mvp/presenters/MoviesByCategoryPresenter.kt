package com.cep.moviesworld.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.cep.moviesworld.mvp.views.MovieByCategoryView

interface MoviesByCategoryPresenter: BasePresenter<MovieByCategoryView> {

    fun onUIReadyMovies(lifecycleOwner: LifecycleOwner)
}