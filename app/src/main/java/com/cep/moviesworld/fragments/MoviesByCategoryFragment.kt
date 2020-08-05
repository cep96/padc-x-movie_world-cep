package com.cep.moviesworld.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cep.moviesworld.R
import com.cep.moviesworld.activities.MovieDetailsActivity
import com.cep.moviesworld.adapters.MoviesByCategoryRecyclerAdapter
import com.cep.moviesworld.data.vos.ResultsVO
import com.cep.moviesworld.mvp.presenters.MoviesByCategoryPresenter
import com.cep.moviesworld.mvp.presenters.MoviesByCategoryPresenterImpl
import com.cep.moviesworld.mvp.views.MovieByCategoryView
import kotlinx.android.synthetic.main.fragment_movie_category.*

class MoviesByCategoryFragment : Fragment(), MovieByCategoryView {

    private var genreId = 0

    private lateinit var mPresenter: MoviesByCategoryPresenter
    private lateinit var mMoviesByCategoryAdapter: MoviesByCategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            genreId = it.getInt(ARG_GENRE_ID)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_by_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()

        setUpRecyclerView()

        mPresenter.onUIReadyMovies(this, genreId)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this.requireActivity()).get(MoviesByCategoryPresenterImpl::class.java)
    }

    private fun setUpRecyclerView() {
//        mMoviesByCategoryAdapter = MoviesByCategoryRecyclerAdapter()

        val layoutManager = LinearLayoutManager(this.requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvMoviesByCategory.layoutManager = layoutManager
        rvMoviesByCategory.adapter = mMoviesByCategoryAdapter
    }

    override fun displayMoviesByGenre(movies: List<ResultsVO>) {
        mMoviesByCategoryAdapter.setNewData(movies.toMutableList())
    }

    override fun navigateToMovieDetails(movieId: Int) {
        startActivity(MovieDetailsActivity.newIntent(this.requireContext(), movieId))
    }

    companion object {

        const val ARG_GENRE_ID = "ARG_GENRE_ID"

        @JvmStatic
        fun newInstance(genreId: Int) =
            MoviesByCategoryFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_GENRE_ID, genreId)
                }
            }
    }
}