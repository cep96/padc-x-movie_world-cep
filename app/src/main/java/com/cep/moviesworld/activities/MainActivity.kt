package com.cep.moviesworld.activities

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.cep.moviesworld.R
import com.cep.moviesworld.mvp.presenters.MainPresenter
import com.cep.moviesworld.mvp.views.MainView

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        setUpPresenter()

    }

    private fun setUpPresenter() {
    }

    override fun getPopularFilmsAndSerials() {
        TODO("Not yet implemented")
    }

    override fun getCategories() {
        TODO("Not yet implemented")
    }

    override fun getMoviesByCategory() {
        TODO("Not yet implemented")
    }

    override fun getShowcases() {
        TODO("Not yet implemented")
    }

    override fun getBestActors() {
        TODO("Not yet implemented")
    }

    override fun navigateToMovieDetails() {
        TODO("Not yet implemented")
    }

}