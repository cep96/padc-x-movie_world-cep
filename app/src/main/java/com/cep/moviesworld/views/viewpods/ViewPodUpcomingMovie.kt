package com.cep.moviesworld.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.cep.moviesworld.data.vos.ResultsVO
import com.cep.moviesworld.utils.GET_MOVIE_IMAGE
import kotlinx.android.synthetic.main.viewpod_movie_review.view.*

class ViewPodUpcomingMovie @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var mDelegate: Delegate? = null
    private var movieId = 0

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    private fun setUpListener() {
        ivPlay.setOnClickListener {
            mDelegate?.onTapPlay(movieId)
        }
    }

    fun bindData(movie: ResultsVO){
        Glide.with(context)
            .load("$GET_MOVIE_IMAGE${movie.posterPath}")
            .into(ivMovieImg)

        tvMovieName.text = movie.title
        movieId = movie.id
    }

    fun setDelegate(delegate: Delegate){
        mDelegate = delegate
    }

    interface Delegate{
        fun onTapPlay(movieId: Int)
    }
}