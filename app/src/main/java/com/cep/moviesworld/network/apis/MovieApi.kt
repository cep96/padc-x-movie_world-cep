package com.cep.moviesworld.network.apis

import com.cep.moviesworld.network.responses.*
import com.cep.moviesworld.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET(GET_POPULAR_FILMS_AND_SERIALS)
    fun getPopularFilmsAndSerials(
        @Query("api_key") apiKey: String
    ): Observable<PopularFilmsAndSerialsResponse>

    @GET(GET_GENRES)
    fun getGenres(
        @Query("api_key") apiKey: String
    ): Observable<GenresResponse>

    @GET(GET_POPULAR_PERSON)
    fun getPopularPerson(
        @Query("api_key") apiKey: String
    ): Observable<GetPopularPeopleResponse>

    @GET(GET_MOVIE_DETAILS)
    fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): Observable<GetMovieDetailsResponse>

    @GET(GET_MOVIES_UPCOMING)
    fun getMoviesUpcoming(
        @Query("api_key") apiKey: String
    ): Observable<GetMovieUpcomingResponse>

    @GET(GET_MOVIE_TRAILERS)
    fun getMovieTrailers(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): Observable<GetMovieTrailerResponse>

    @GET(GET_MOVIES_BY_GENRES)
    fun getMoviesByGenres(
        @Query("api_key") apiKey: String,
        @Query("with_genres") withGenres: Int
    ): Observable<PopularFilmsAndSerialsResponse>

    @GET(GET_CAST_AND_CREW_FOR_MOVIE)
    fun getCastAndCrewForMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): Observable<GetMovieCastAndCrewResponse>



}