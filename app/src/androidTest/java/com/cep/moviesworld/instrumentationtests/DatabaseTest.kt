package com.cep.moviesworld.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.cep.moviesworld.data.dummydata.getDummyMovies
import com.cep.moviesworld.persistence.daos.MoviesDao
import com.cep.moviesworld.persistence.db.MovieDB
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {

    private lateinit var moviesDao: MoviesDao
    private lateinit var moviesDataBase: MovieDB

    @Before
    fun createDB(){
        val context = ApplicationProvider.getApplicationContext<Context>()

        moviesDataBase = Room.inMemoryDatabaseBuilder(context, MovieDB::class.java).build()

        moviesDao = moviesDataBase.movieDao()
    }

    @After
    fun closeDB(){
        moviesDataBase.close()
    }

    @Test
    fun insertIntoDataBaseTest(){
        moviesDao.insertPopularMovies(getDummyMovies())
    }

}