package com.cep.moviesworld.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cep.moviesworld.R
import com.cep.moviesworld.adapters.*
import com.cep.moviesworld.data.vos.GenreVO
import com.cep.moviesworld.data.vos.PersonVO
import com.cep.moviesworld.data.vos.ResultsVO
import com.cep.moviesworld.mvp.presenters.MainPresenter
import com.cep.moviesworld.mvp.presenters.MainPresenterImpl
import com.cep.moviesworld.mvp.views.MainView
import com.cep.moviesworld.network.responses.GetMovieTrailerResponse
import com.cep.moviesworld.views.viewpods.ViewPodUpcomingMovie
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.actor.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.showcases.*
import kotlinx.android.synthetic.main.viewpod_movies_by_genre.*
import kotlinx.android.synthetic.main.viewpod_popular_films_and_serials.*

class MainActivity : AppCompatActivity(), MainView{

    private lateinit var mPresenter: MainPresenter

    private lateinit var mPopularMovieAdapter: BestPopularFilmsAndSerialsRecyclerAdapter
    private lateinit var mShowcasesAdapter: ShowcasesRecyclerAdapter
    private lateinit var mActorAdapter: ActorRecyclerAdapter
    private lateinit var mMovieByCategoryAdapter: MoviesByCategoryRecyclerAdapter

    private lateinit var mViewpagerAdapter: MoviesUpcomingPagerAdapter

    private var genreList: List<GenreVO> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        setUpPresenter()

        setUpPopularMovieRecyclerView()
        setUpActorRecyclerView()
        setUpShowcasesRecyclerView()
        setUpMoviesByGenreRecyclerView()
        setUpViewpager()

        setUpTabListener()

        mPresenter.onUIReadyForPopularFilmsAndSerials(this)
        mPresenter.onUIReadyForShowcases(this)
        mPresenter.onUIReadyForActors(this)
        mPresenter.onUIReadyForGenres(this)

        mPresenter.onUIReadyForUpcomingMovie(this)
    }

    private fun setUpViewpager() {
        mViewpagerAdapter = MoviesUpcomingPagerAdapter( mPresenter, this)

        viewPager.adapter = mViewpagerAdapter
        dots_indicator.setViewPager(viewPager)
    }

    private fun setUpTabListener() {
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                mPresenter.onUIReadyForMoviesByGenre(
                    this@MainActivity,
                    genreList[tab!!.position].id
                )
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                mPresenter.onUIReadyForMoviesByGenre(
                    this@MainActivity,
                    genreList[tab!!.position].id
                )
            }

        })
    }

    private fun setUpMoviesByGenreRecyclerView() {
        mMovieByCategoryAdapter = MoviesByCategoryRecyclerAdapter(mPresenter)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvMoviesByGenre.layoutManager = layoutManager
        rvMoviesByGenre.adapter = mMovieByCategoryAdapter

    }

    private fun setUpTabLayout() {
        for (genre in genreList) {
            tabLayout.addTab(tabLayout.newTab().setText(genre.name))
        }
    }

    private fun setUpShowcasesRecyclerView() {
        mShowcasesAdapter = ShowcasesRecyclerAdapter()

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvShowCases.layoutManager = linearLayoutManager
        rvShowCases.adapter = mShowcasesAdapter
    }

    private fun setUpActorRecyclerView() {
        mActorAdapter = ActorRecyclerAdapter()

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvActor.layoutManager = linearLayoutManager
        rvActor.adapter = mActorAdapter

    }

    private fun setUpPopularMovieRecyclerView() {
        mPopularMovieAdapter = BestPopularFilmsAndSerialsRecyclerAdapter(mPresenter)

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvPopularFilmsAndSerials.layoutManager = linearLayoutManager
        rvPopularFilmsAndSerials.adapter = mPopularMovieAdapter

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun displayPopularFilmsAndSerials(popularFilmsAndSerials: List<ResultsVO>) {
        mPopularMovieAdapter.setNewData(popularFilmsAndSerials.toMutableList())
    }

    override fun displayShowcases(showcases: List<String>) {
        mShowcasesAdapter.setNewData(showcases.toMutableList())
    }

    override fun displayBestActors(actors: List<PersonVO>) {
        mActorAdapter.setNewData(actors.toMutableList())
    }

    override fun getGenres(genres: List<GenreVO>) {
        genreList = genres
        setUpTabLayout()
//        mCategoryPagerAdapter.setData(genres)
    }

    override fun displayMoviesByGenre(movies: List<ResultsVO>) {
        Log.d("movieByGenres", "==> $movies")
        mMovieByCategoryAdapter.setNewData(movies.toMutableList())

    }

    override fun displayUpcomingMovies(movies: List<ResultsVO>) {
        mViewpagerAdapter.setData(movies)
    }

    override fun navigateToMovieDetails(movieId: Int) {
        startActivity(MovieDetailsActivity.newIntent(this, movieId))
    }

    override fun navigateToVideo(movieId: Int) {
        mPresenter.onDataReadyForTrailer(this, movieId)
//        Toast.makeText(this, "Play", Toast.LENGTH_LONG).show()
    }

    override fun getMovieTrailer(movie: GetMovieTrailerResponse) {
        val youtubeKey = movie.results[0].key
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$youtubeKey")))
    }

}