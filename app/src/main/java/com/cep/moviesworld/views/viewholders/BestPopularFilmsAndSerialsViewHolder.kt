package com.cep.moviesworld.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.cep.moviesworld.data.vos.ResultsVO
import com.cep.moviesworld.delegates.MovieItemDelegate
import com.cep.moviesworld.utils.GET_MOVIE_IMAGE
import com.cep.moviesworld.views.viewpods.PopularFilmsAndSerialsViewPod
import kotlinx.android.synthetic.main.item_popular_films_and_serials.view.*
import kotlinx.android.synthetic.main.viewpod_movie.view.*

class BestPopularFilmsAndSerialsViewHolder(
    itemView: View, private val delegate: PopularFilmsAndSerialsViewPod.Delegate
) : BaseViewHolder<ResultsVO>(itemView) {


//    init {
//        itemView.setOnClickListener {
//            mData?.let {
////                delegate.onTapItem(it.id)
//                delegate.onTapMovieItem(it.id)
//            }
//        }
//
//    }

    override fun bindData(data: ResultsVO) {
        Glide.with(itemView)
            .load(GET_MOVIE_IMAGE + data.posterPath)
            .into(itemView.ivMovie)

        itemView.tvPopularFilmsAndSerialsMovieName.text = data.title
        itemView.tvRating.text = data.voteAverage.toString()

        itemView.setOnClickListener {
//            delegate.onTapMovieItem(data.id)
            delegate.onTapItem(data.id)
        }
    }
}