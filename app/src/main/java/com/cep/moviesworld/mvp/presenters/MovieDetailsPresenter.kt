package com.cep.moviesworld.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.cep.moviesworld.mvp.views.MovieDetailsView

interface MovieDetailsPresenter: BasePresenter<MovieDetailsView> {

    fun onUIReadyForMovie(lifecycleOwner: LifecycleOwner, movieId: Int)
    fun onUIReadyForActors(lifecycleOwner: LifecycleOwner)
    fun onUIReadyForCreators(lifecycleOwner: LifecycleOwner)
    fun onDataReadyForMovieCastAndCrew(lifecycleOwner: LifecycleOwner, movieId: Int)
}