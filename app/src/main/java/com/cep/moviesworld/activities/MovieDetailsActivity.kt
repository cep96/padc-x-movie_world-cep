package com.cep.moviesworld.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.cep.moviesworld.R
import com.cep.moviesworld.adapters.ActorRecyclerAdapter
import com.cep.moviesworld.adapters.CastRecyclerAdapter
import com.cep.moviesworld.adapters.CrewRecyclerAdapter
import com.cep.moviesworld.data.vos.CastVO
import com.cep.moviesworld.data.vos.CrewVO
import com.cep.moviesworld.data.vos.PersonVO
import com.cep.moviesworld.mvp.presenters.MovieDetailsPresenterImpl
import com.cep.moviesworld.mvp.views.MovieDetailsView
import com.cep.moviesworld.network.responses.GetMovieDetailsResponse
import com.cep.moviesworld.utils.GET_MOVIE_IMAGE
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.viewpod_about_film.*
import kotlinx.android.synthetic.main.viewpod_actors.*
import kotlinx.android.synthetic.main.viewpod_creators.*
import kotlinx.android.synthetic.main.viewpod_movie_info.*
import kotlinx.android.synthetic.main.viewpod_time_favorite_and_type.*

class MovieDetailsActivity : AppCompatActivity(), MovieDetailsView {

    private lateinit var mPresenter: MovieDetailsPresenterImpl

    private lateinit var mActorRecyclerAdapter: CastRecyclerAdapter
    private lateinit var mCreatorRecyclerAdapter: CrewRecyclerAdapter

    private var movieId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        ivBackArrow.setOnClickListener { onBackPressed() }

        movieId = intent.getIntExtra(EXTRA_MOVIE_ID, 0)

        setUpPresenter()

        setUpActorRecyclerView()
        setUpCreatorRecyclerView()

//        mPresenter.onUIReadyForActors(this)
//        mPresenter.onUIReadyForCreators(this)
        mPresenter.onUIReadyForMovie(this, movieId)
        mPresenter.onDataReadyForMovieCastAndCrew(this,movieId)

    }

    private fun setUpActorRecyclerView() {

        mActorRecyclerAdapter = CastRecyclerAdapter()

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvActors.layoutManager = layoutManager
        rvActors.adapter = mActorRecyclerAdapter

    }

    private fun setUpCreatorRecyclerView(){

        mCreatorRecyclerAdapter = CrewRecyclerAdapter()

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCreators.layoutManager = layoutManager
        rvCreators.adapter = mActorRecyclerAdapter
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MovieDetailsPresenterImpl::class.java)
        mPresenter.initPresenter(this)

    }

    companion object{
        const val EXTRA_MOVIE_ID = "EXTRA_MOVIE_ID"

        fun newIntent(context: Context, movieId: Int): Intent{
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra(EXTRA_MOVIE_ID, movieId)
            return intent
        }
    }

    override fun displayMovieInformation(movie: GetMovieDetailsResponse) {
        Glide.with(this)
            .load("$GET_MOVIE_IMAGE${movie.posterPath}")
            .into(ivMovieImage)

        val year = movie.releaseDate.split("-")
        tvReleaseDate.text = year[0]

        tvMovieTitle.text = movie.title

        tvVoteCount.text = "${movie.voteCount} Votes"
        tvPopularity.text = movie.popularity.toString()

        tvDuration.text = "${(movie.runtime)/60}hr ${(movie.runtime)%60}min"

        tvStoryLineDesc.text = movie.tagLine

        tvOriginalTitle.text = movie.originalTitle
        var movieType = ""
        for (type in movie.genres){
            movieType += "${type.name},"
        }
        tvType.text = movieType

        var productionCountries = ""
        for (country in movie.productionCountries){
            productionCountries += "${country.name},"
        }
        tvProduction.text = productionCountries

        tvPremiere.text = movie.releaseDate
        tvDescription.text = movie.overview

    }

    override fun displayCasts(casts: List<CastVO>) {
        mActorRecyclerAdapter.setNewData(casts.toMutableList())
    }

    override fun displayCrew(crew: List<CrewVO>) {
        mCreatorRecyclerAdapter.setNewData(crew.toMutableList())
    }
}