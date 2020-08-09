package com.cep.moviesworld.mvp.presenters

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.cep.moviesworld.data.models.MovieModel
import com.cep.moviesworld.data.models.MovieModelImpl
import com.cep.moviesworld.mvp.views.MainView
import com.cep.moviesworld.network.responses.GetMovieCastAndCrewResponse
import com.cep.moviesworld.network.responses.GetMovieTrailerResponse
import com.cep.moviesworld.network.responses.GetMovieUpcomingResponse
import com.cep.moviesworld.network.responses.PopularFilmsAndSerialsResponse
import com.cep.shared.AbstractBasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers

class MainPresenterImpl: MainPresenter, AbstractBasePresenter<MainView>() {

  var mMovieModel : MovieModel = MovieModelImpl

    private val strArray: List<String> = arrayListOf("1", "2", "3", "4", "5")

    override fun onUIReadyForPopularFilmsAndSerials(lifecycleOwner: LifecycleOwner) {
        loadPopularMoviesFromApi()
        requestPopularMovies(lifecycleOwner)
    }

    override fun onUIReadyForGenres(lifecycleOwner: LifecycleOwner) {
        loadGenresFromApi()
        requestGenres(lifecycleOwner)
    }

    private fun requestGenres(lifecycleOwner: LifecycleOwner) {
        mMovieModel.getGenres()
            .observe(lifecycleOwner, Observer {
                mView?.getGenres(it)
            })
    }

    private fun loadGenresFromApi() {
        mMovieModel.getGenresFromApiAndSaveToDB(
            onError = {}
        )
    }

    private fun requestPopularMovies(lifecycleOwner: LifecycleOwner) {
        mMovieModel.getPopularFilmsAndSerials()
            .observe(lifecycleOwner, Observer {
                Log.d("MainActivity", "==> $it")
                mView?.displayPopularFilmsAndSerials(it)
            })
    }

    private fun loadPopularMoviesFromApi() {
        mMovieModel.getPopularMoviesFromApiAndSaveToDB(
            onError = {}
        )
    }

    override fun onUIReadyForShowcases(lifecycleOwner: LifecycleOwner) {
        mView?.displayShowcases(strArray)
    }

    override fun onUIReadyForActors(lifecycleOwner: LifecycleOwner) {
        loadPopularPersonFromApi()
        requestPopularPerson(lifecycleOwner)
    }

    @SuppressLint("CheckResult")
    override fun onUIReadyForMoviesByGenre(lifecycleOwner: LifecycleOwner, genreId: Int) {
        val movies = MutableLiveData<PopularFilmsAndSerialsResponse>()

        mMovieModel.getMoviesByGenres(genreId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                movies.postValue(it)
            },{
                movies.postValue(null)
            })

        movies.observe(lifecycleOwner, Observer {
            mView?.displayMoviesByGenre(it.result!!)
        })
//        requestMoviesByGenre(lifecycleOwner, genreId)
    }

    @SuppressLint("CheckResult")
    override fun onUIReadyForUpcomingMovie(lifecycleOwner: LifecycleOwner) {
        val comingMovies = MutableLiveData<GetMovieUpcomingResponse>()

        mMovieModel.getMoviesUpcoming()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                comingMovies.postValue(it)
            },{
                comingMovies.postValue(null)
            })

        comingMovies.observe(
            lifecycleOwner, Observer {
                mView?.displayUpcomingMovies(it.results)
            }
        )

//        loadUpcomingMoviesFromApi()
//        requestUpcomingMovies(lifecycleOwner)
    }

    @SuppressLint("CheckResult")
    override fun onDataReadyForTrailer(lifecycleOwner: LifecycleOwner, movieId: Int) {
        var movie = MutableLiveData<GetMovieTrailerResponse>()

        mMovieModel.getMovieTrailer(movieId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                movie.postValue(it)
            },{
                movie.postValue(null)
            })

        movie.observe(lifecycleOwner, Observer {
            it.apply {
                mView?.getMovieTrailer(it)
            }

        })
    }

//    private fun requestUpcomingMovies(lifecycleOwner: LifecycleOwner) {
//        mMovieModel.getMoviesUpcoming()
//            .observe(lifecycleOwner, Observer {
//                mView?.displayUpcomingMovies(it)
//            })
//    }

    private fun loadUpcomingMoviesFromApi() {
        mMovieModel.getMoviesUpcomingFromApiAndSaveToDB(
            onError = {}
        )
    }

    override fun onTapItem(movieId: Int) {
        mView?.navigateToMovieDetails(movieId)
    }

    override fun onTapPlay(movieId: Int) {
        mView?.navigateToVideo(movieId)
    }


//    override fun onTapMovieItem(movieId: Int) {
//        mView?.navigateToMovieDetails(movieId)
//    }

//    private fun requestMoviesByGenre(lifecycleOwner: LifecycleOwner, genreId: Int) {
//        mMovieModel.getMoviesByGenre(genreId)
//            .observe(lifecycleOwner, Observer {
//                mView?.displayMoviesByGenre(it)
//                Log.d("movie list", "==> $it")
//            })
//    }

    private fun requestPopularPerson(lifecycleOwner: LifecycleOwner) {
        mMovieModel.getPopularPerson()
            .observe(lifecycleOwner, Observer {
                mView?.displayBestActors(it)
            })
    }

    private fun loadPopularPersonFromApi() {
        mMovieModel.getPopularPersonFromApiAndSaveToDB(
            onError = {}
        )
    }

}