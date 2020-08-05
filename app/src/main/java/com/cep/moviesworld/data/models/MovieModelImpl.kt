package com.cep.moviesworld.data.models

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.cep.moviesworld.data.vos.GenreVO
import com.cep.moviesworld.data.vos.PersonVO
import com.cep.moviesworld.data.vos.ResultsVO
import com.cep.moviesworld.network.responses.*
import com.cep.moviesworld.utils.API_KEY
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object MovieModelImpl: BaseModel(), MovieModel {

    override fun getPopularFilmsAndSerials(): LiveData<List<ResultsVO>> {
        return mMovieDB.movieDao()
            .getPopularMovies()
    }

    @SuppressLint("CheckResult")
    override fun getPopularMoviesFromApiAndSaveToDB(onError: (String) -> Unit) {
        provideMovieApiService().getPopularFilmsAndSerials(API_KEY)
            .map { it.result?.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("movie", "==> $it")
                mMovieDB.movieDao().insertPopularMovies(it!!)
            },{
                onError(it.localizedMessage)
            })
    }

    override fun getGenres(): LiveData<List<GenreVO>> {
        return mMovieDB.movieDao()
            .getGenres()
    }

    @SuppressLint("CheckResult")
    override fun getGenresFromApiAndSaveToDB(onError: (String) -> Unit) {
        provideMovieApiService().getGenres(API_KEY)
            .map { it.genres?.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mMovieDB.movieDao().insertGenres(it)
            },{
                onError(it.localizedMessage)
            })
    }

    override fun getPopularPerson(): LiveData<List<PersonVO>> {
        return mMovieDB.movieDao()
            .getPopularPerson()
    }

    @SuppressLint("CheckResult")
    override fun getPopularPersonFromApiAndSaveToDB(onError: (String) -> Unit) {
            provideMovieApiService().getPopularPerson(API_KEY)
                .map { it.results?.toList() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mMovieDB.movieDao().insertPopularPerson(it)
                },{
                    onError(it.localizedMessage)
                })
    }

    override fun getMovieCastAndCrew(movieId: Int): Observable<GetMovieCastAndCrewResponse> {
        return provideMovieApiService().getCastAndCrewForMovie(movieId, API_KEY)
            .subscribeOn(Schedulers.io())
    }

//    override fun getMoviesByGenre(genreId: Int): Observable<List<ResultsVO>> {
//        return mMovieDB.movieDao()
//            .getMoviesByGenre(genreId)
//    }

    override fun getMovie(movieId: Int): LiveData<ResultsVO> {
        return mMovieDB.movieDao()
            .getMovie(movieId)
    }

    override fun getMovieDetails(movieId: Int): Observable<GetMovieDetailsResponse> {
        return provideMovieApiService().getMovieDetails(movieId, API_KEY)
            .subscribeOn(Schedulers.io())
    }

    @SuppressLint("CheckResult")
    override fun getMoviesUpcomingFromApiAndSaveToDB(onError: (String) -> Unit) {
        provideMovieApiService().getMoviesUpcoming(API_KEY)
            .map { it.results?.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mMovieDB.movieDao().insertUpcomingMovies(it)
            },{
                onError(it.localizedMessage)
            })
    }

    override fun getMoviesUpcoming(): Observable<GetMovieUpcomingResponse> {
//        return mMovieDB.movieDao()
//            .getUpcomingMovies()
        return provideMovieApiService().getMoviesUpcoming(API_KEY)
            .subscribeOn(Schedulers.io())
    }

    override fun getMovieTrailer(movieId: Int): Observable<GetMovieTrailerResponse> {
        return provideMovieApiService().getMovieTrailers(movieId, API_KEY)
            .subscribeOn(Schedulers.io())
    }

    override fun getMoviesByGenres(genresId: Int): Observable<PopularFilmsAndSerialsResponse> {
        return provideMovieApiService().getMoviesByGenres(API_KEY, genresId)
            .subscribeOn(Schedulers.io())
    }

}