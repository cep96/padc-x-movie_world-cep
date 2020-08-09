package com.cep.moviesworld.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.cep.moviesworld.data.models.MovieModelImpl
import com.cep.moviesworld.mvp.views.MovieByCategoryView
import com.cep.shared.AbstractBasePresenter

class MoviesByCategoryPresenterImpl: MoviesByCategoryPresenter,
    AbstractBasePresenter<MovieByCategoryView>() {

    private var mMovieModel = MovieModelImpl

    private val strArray: List<String> = arrayListOf()

//    override fun onUIReadyMovies(lifecycleOwner: LifecycleOwner) {
//        mView?.displayMoviesByCategory(strArray)
//
//    }

    private fun requestMovieByGenre(lifecycleOwner: LifecycleOwner, genreId: Int) {
//        mMovieModel.getMoviesByGenre(genreId)
//            .observe(lifecycleOwner, Observer {
//                mView?.displayMoviesByGenre(it)
//            })

    }

    override fun onUIReadyMovies(lifecycleOwner: LifecycleOwner, genreId: Int) {
        requestMovieByGenre(lifecycleOwner, genreId)
    }
}