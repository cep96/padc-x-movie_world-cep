package com.cep.moviesworld.mvp.views

import com.cep.moviesworld.data.vos.*
import com.cep.moviesworld.network.responses.GetMovieTrailerResponse
import com.cep.shared.BaseView

interface MainView : BaseView {

    fun displayPopularFilmsAndSerials(popularFilmsAndSerials: List<ResultsVO>)
    fun displayShowcases(showcases: List<String>)
    fun displayBestActors(actors: List<PersonVO>)
    fun getGenres(genres: List<GenreVO>)

    fun displayMoviesByGenre(movies: List<ResultsVO>)
    fun displayUpcomingMovies(movies: List<ResultsVO>)

    fun navigateToMovieDetails(movieId: Int)
    fun navigateToVideo(movieId: Int)

    fun getMovieTrailer(movie: GetMovieTrailerResponse)
}