package com.cep.moviesworld.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.cep.moviesworld.delegates.MovieItemDelegate
import com.cep.moviesworld.mvp.views.MainView
import com.cep.moviesworld.views.viewpods.PopularFilmsAndSerialsViewPod
import com.cep.moviesworld.views.viewpods.ViewPodUpcomingMovie
import java.util.*

interface MainPresenter: BasePresenter<MainView>, PopularFilmsAndSerialsViewPod.Delegate,
ViewPodUpcomingMovie.Delegate{

    fun onUIReadyForPopularFilmsAndSerials(lifecycleOwner: LifecycleOwner)
    fun onUIReadyForGenres(lifecycleOwner: LifecycleOwner)
    fun onUIReadyForShowcases(lifecycleOwner: LifecycleOwner)
    fun onUIReadyForActors(lifecycleOwner: LifecycleOwner)
    fun onUIReadyForMoviesByGenre(lifecycleOwner: LifecycleOwner, genreId: Int)
    fun onUIReadyForUpcomingMovie(lifecycleOwner: LifecycleOwner)

    fun onDataReadyForTrailer(lifecycleOwner: LifecycleOwner, movieId: Int)
}