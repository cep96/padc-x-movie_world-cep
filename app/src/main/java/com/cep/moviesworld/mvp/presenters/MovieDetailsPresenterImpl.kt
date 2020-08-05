package com.cep.moviesworld.mvp.presenters

import android.annotation.SuppressLint
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.cep.moviesworld.data.models.MovieModelImpl
import com.cep.moviesworld.mvp.views.MovieDetailsView
import com.cep.moviesworld.network.responses.GetMovieCastAndCrewResponse
import com.cep.moviesworld.network.responses.GetMovieDetailsResponse
import io.reactivex.android.schedulers.AndroidSchedulers

class MovieDetailsPresenterImpl: MovieDetailsPresenter, AbstractBasePresenter<MovieDetailsView>() {

    private val mMovieModel = MovieModelImpl

    @SuppressLint("CheckResult")
    override fun onUIReadyForMovie(lifecycleOwner: LifecycleOwner, movieId: Int) {
        var movie = MutableLiveData<GetMovieDetailsResponse>()

        mMovieModel.getMovieDetails(movieId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                movie.postValue(it)
            },{
                movie.postValue(null)
            })

        movie.observe(lifecycleOwner, Observer {
            mView?.displayMovieInformation(it)
        })
//        mMovieModel.getMovie(movieId)
//            .observe(lifecycleOwner, Observer {
//                mView?.displayMovieInformation(it)
//            })
    }

    override fun onUIReadyForActors(lifecycleOwner: LifecycleOwner) {
        mMovieModel.getPopularPerson()
            .observe(lifecycleOwner, Observer {
//                mView?.displayActors(it)
            })
    }

    override fun onUIReadyForCreators(lifecycleOwner: LifecycleOwner) {
       mMovieModel.getPopularPerson()
           .observe(lifecycleOwner, Observer {
//               mView?.displayCreators(it)
           })
    }

    @SuppressLint("CheckResult")
    override fun onDataReadyForMovieCastAndCrew(lifecycleOwner: LifecycleOwner, movieId: Int) {
        val movieCastAndCrew = MutableLiveData<GetMovieCastAndCrewResponse>()

        mMovieModel.getMovieCastAndCrew(movieId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                movieCastAndCrew.postValue(it)
            },{
                movieCastAndCrew.postValue(null)
            })

        movieCastAndCrew.observe(lifecycleOwner, Observer {
            it.apply {
                mView?.displayCasts(it.cast)
                mView?.displayCrew(it.crew)
            }

        })

    }
}