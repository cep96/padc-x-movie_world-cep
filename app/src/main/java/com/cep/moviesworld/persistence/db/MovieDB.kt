package com.cep.moviesworld.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cep.moviesworld.data.vos.GenreVO
import com.cep.moviesworld.data.vos.PersonVO
import com.cep.moviesworld.data.vos.ResultsVO
import com.cep.moviesworld.persistence.daos.MoviesDao
import com.cep.moviesworld.persistence.typeconverters.GenresTypeConverter
import com.cep.moviesworld.persistence.typeconverters.KnownForTypeConverter

@Database(entities = [ResultsVO::class, GenreVO::class, PersonVO::class], version = 2, exportSchema = false)
@TypeConverters(GenresTypeConverter::class, KnownForTypeConverter::class)
abstract class MovieDB: RoomDatabase() {

    companion object{
        const val DB_NAME = "MOVIE_WORLD.DB"
        var dbInstance: MovieDB? = null

        fun getDBInstance(context: Context): MovieDB{
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, MovieDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }

    abstract fun movieDao() : MoviesDao
}