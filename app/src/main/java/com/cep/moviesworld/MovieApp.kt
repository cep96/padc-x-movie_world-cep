package com.cep.moviesworld

import android.app.Application
import com.cep.moviesworld.data.models.MovieModelImpl

class MovieApp: Application() {

    override fun onCreate() {
        super.onCreate()

        MovieModelImpl.initDatabase(applicationContext)
    }
}