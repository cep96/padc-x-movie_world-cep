package com.cep.moviesworld.data.models

import android.content.Context
import com.cep.moviesworld.network.apis.MovieApi
import com.cep.moviesworld.persistence.db.MovieDB
import com.cep.moviesworld.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {

    private lateinit var retrofit: Retrofit
    protected lateinit var mMovieDB: MovieDB

    init {
        initNetWork()
    }

    private fun initNetWork(){

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun initDatabase(context: Context){
        mMovieDB = MovieDB.getDBInstance(context)
    }

    fun provideMovieApiService(): MovieApi{
        return retrofit.create(MovieApi::class.java)
    }

    fun init(context: Context){
        initDatabase(context)
    }
}