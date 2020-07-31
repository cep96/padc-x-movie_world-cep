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
import com.cep.moviesworld.mvp.presenters.MoviesByCategoryPresenter
import com.cep.moviesworld.mvp.presenters.MoviesByCategoryPresenterImpl
import com.cep.moviesworld.mvp.views.MovieByCategoryView
import kotlinx.android.synthetic.main.fragment_movie_category.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MoviesByCategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoviesByCategoryFragment : Fragment(), MovieByCategoryView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mPresenter: MoviesByCategoryPresenter
    private lateinit var mMoviesByCategoryAdapter: MoviesByCategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
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

        mPresenter.onUIReadyMovies(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this.requireActivity()).get(MoviesByCategoryPresenterImpl::class.java)
    }

    private fun setUpRecyclerView() {
        mMoviesByCategoryAdapter = MoviesByCategoryRecyclerAdapter()

        val layoutManager = LinearLayoutManager(this.requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvMoviesByCategory.layoutManager = layoutManager
        rvMoviesByCategory.adapter = mMoviesByCategoryAdapter
    }

    override fun displayMoviesByCategory(movies: List<String>) {
        mMoviesByCategoryAdapter.setNewData(movies.toMutableList())
    }

    override fun navigateToMovieDetails(movieId: Int) {
        startActivity(MovieDetailsActivity.newIntent(this.requireContext(), movieId))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MoviesByCategoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MoviesByCategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}