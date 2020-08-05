package com.cep.moviesworld.data.models

import androidx.lifecycle.LiveData
import com.cep.moviesworld.data.vos.GenreVO
import com.cep.moviesworld.data.vos.PersonVO
import com.cep.moviesworld.data.vos.ResultsVO
import com.cep.moviesworld.network.responses.*
import io.reactivex.Observable

interface MovieModel {

    fun getPopularFilmsAndSerials(): LiveData<List<ResultsVO>>

    fun getPopularMoviesFromApiAndSaveToDB(onError:(String) -> Unit)

    fun getGenres(): LiveData<List<GenreVO>>

    fun getGenresFromApiAndSaveToDB(onError: (String) -> Unit)

    fun getPopularPerson(): LiveData<List<PersonVO>>

    fun getPopularPersonFromApiAndSaveToDB(onError: (String) -> Unit)

    fun getMovieCastAndCrew(movieId: Int): Observable<GetMovieCastAndCrewResponse>

    fun getMovie(movieId: Int): LiveData<ResultsVO>

    fun getMovieDetails(movieId: Int): Observable<GetMovieDetailsResponse>

    fun getMoviesUpcomingFromApiAndSaveToDB(onError: (String) -> Unit)

    fun getMoviesUpcoming(): Observable<GetMovieUpcomingResponse>

    fun getMovieTrailer(movieId: Int): Observable<GetMovieTrailerResponse>

    fun getMoviesByGenres(genresId: Int): Observable<PopularFilmsAndSerialsResponse>
}