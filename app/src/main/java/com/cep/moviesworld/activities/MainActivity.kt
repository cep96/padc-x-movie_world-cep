package com.cep.moviesworld.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cep.moviesworld.R
import com.cep.moviesworld.adapters.ActorRecyclerAdapter
import com.cep.moviesworld.adapters.BestPopularFilmsAndSerialsRecyclerAdapter
import com.cep.moviesworld.adapters.CategoryPagerAdapter
import com.cep.moviesworld.adapters.ShowcasesRecyclerAdapter
import com.cep.moviesworld.mvp.presenters.MainPresenter
import com.cep.moviesworld.mvp.presenters.MainPresenterImpl
import com.cep.moviesworld.mvp.views.MainView
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.actor.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.showcases.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mPresenter: MainPresenter

    private lateinit var mPopularMovieAdapter: BestPopularFilmsAndSerialsRecyclerAdapter
    private lateinit var mShowcasesAdapter: ShowcasesRecyclerAdapter
    private lateinit var mActorAdapter: ActorRecyclerAdapter

    private lateinit var mCategoryPagerAdapter: CategoryPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        setUpPresenter()

        setUpPopularMovieRecyclerView()
        setUpActorRecyclerView()
        setUpShowcasesRecyclerView()
        setUpViewPager()

        mPresenter.onUIReadyForPopularFilmsAndSerials(this)
        mPresenter.onUIReadyForShowcases(this)
        mPresenter.onUIReadyForActors(this)

    }

    private fun setUpViewPager() {
        mCategoryPagerAdapter = CategoryPagerAdapter(this)

        viewPager2.isUserInputEnabled = false
        viewPager2.adapter = mCategoryPagerAdapter

        TabLayoutMediator(tabLayout, viewPager2){ tab, position ->
            when(position){
                0 ->{ tab.text = "ACTION"}
                1 ->{ tab.text = "Adventure" }
                2 ->{ tab.text = "Criminal"}
                3 ->{ tab.text = "Comedy"}
                4 ->{ tab.text = "Drama"}
            }
        }
            .attach()
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
        mPopularMovieAdapter = BestPopularFilmsAndSerialsRecyclerAdapter()

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvPopularFilmsAndSerials.layoutManager = linearLayoutManager
        rvPopularFilmsAndSerials.adapter = mPopularMovieAdapter

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun displayPopularFilmsAndSerials(popularFilmsAndSerials: List<String>) {
        mPopularMovieAdapter.setNewData(popularFilmsAndSerials.toMutableList())
    }

    override fun displayShowcases(showcases: List<String>) {
        mShowcasesAdapter.setNewData(showcases.toMutableList())
    }

    override fun displayBestActors(actors: List<String>) {
        mActorAdapter.setNewData(actors.toMutableList())
    }

    override fun navigateToMovieDetails(movieId: Int) {
        startActivity(MovieDetailsActivity.newIntent(this, movieId))
    }

}