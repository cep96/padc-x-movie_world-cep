package com.cep.moviesworld.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cep.moviesworld.data.vos.GenreVO
import com.cep.moviesworld.data.vos.PersonVO
import com.cep.moviesworld.data.vos.ResultsVO
import com.cep.moviesworld.network.responses.GetMovieUpcomingResponse

@Dao
interface MoviesDao {

    @Query("SELECT * FROM popularMovies")
    fun getPopularMovies(): LiveData<List<ResultsVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovies(movie: List<ResultsVO>)

    //for categories
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenres(category: List<GenreVO>)

    @Query("SELECT * FROM genres")
    fun getGenres(): LiveData<List<GenreVO>>

    //person
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularPerson(person: List<PersonVO>)

    @Query("SELECT * FROM person")
    fun getPopularPerson(): LiveData<List<PersonVO>>

    //movies by genres
    @Query("SELECT * FROM popularMovies WHERE id = :genreId")
    fun getMoviesByGenre(genreId: Int): LiveData<List<ResultsVO>>

    @Query("SELECT * FROM popularMovies WHERE id = :movieId")
    fun getMovie(movieId: Int): LiveData<ResultsVO>

    // upcoming movies
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpcomingMovies(movies: List<ResultsVO>)

    @Query("SELECT * FROM popularMovies")
    fun getUpcomingMovies(): LiveData<List<ResultsVO>>
}