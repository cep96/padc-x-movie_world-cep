package com.cep.moviesworld.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.Glide
import com.cep.moviesworld.R
import com.cep.moviesworld.data.vos.GenreVO
import com.cep.moviesworld.data.vos.ResultsVO
import com.cep.moviesworld.fragments.MoviesByCategoryFragment
import com.cep.moviesworld.utils.GET_MOVIE_IMAGE
import com.cep.moviesworld.views.viewpods.ViewPodUpcomingMovie
import kotlinx.android.synthetic.main.activity_movie_details.view.*
import kotlinx.android.synthetic.main.viewpod_movie_review.view.*

class MoviesUpcomingPagerAdapter(
    private val delegate: ViewPodUpcomingMovie.Delegate,
    private val context: Context
): PagerAdapter(){

    private var movieList: List<ResultsVO> = arrayListOf()
    private val returnCount = 3

    fun setData(movies: List<ResultsVO>){
        movieList = movies
        notifyDataSetChanged()
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` == view
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.viewpod_movie_review, container, false)

        Glide.with(context)
            .load("$GET_MOVIE_IMAGE${movieList[position].posterPath}")
            .into(view.ivMovieImg)

        view.tvMovieName.text = movieList[position].title
        view.ivPlay.setOnClickListener {
            delegate.onTapPlay(movieList[position].id)
        }

//        val viewpod = view.viewpodUpcoming as ViewPodUpcomingMovie
//
//        viewpod.bindData(movieList[position])
//        viewpod.setDelegate(delegate)

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        return container.removeView(`object` as ViewPodUpcomingMovie)
    }

    override fun getCount(): Int {
        return movieList.count()
    }
}