package com.cep.moviesworld.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.cep.moviesworld.data.vos.ResultsVO
import com.cep.moviesworld.utils.GET_MOVIE_IMAGE
import com.cep.moviesworld.views.viewpods.PopularFilmsAndSerialsViewPod
import kotlinx.android.synthetic.main.item_popular_films_and_serials.view.*
import kotlinx.android.synthetic.main.viewpod_movie.view.*
import kotlinx.android.synthetic.main.viewpod_movie_review.view.*

class MoviesByCategoryViewHolder(
    itemView: View,
    private val delegate: PopularFilmsAndSerialsViewPod.Delegate
) : BaseViewHolder<ResultsVO>(itemView) {

    override fun bindData(data: ResultsVO) {
        Glide.with(itemView)
            .load("$GET_MOVIE_IMAGE${data.posterPath}")
            .into(itemView.ivMovie)

        itemView.tvPopularFilmsAndSerialsMovieName.text = data.title
        itemView.tvRating.text = data.voteAverage.toString()

        itemView.setOnClickListener {
            delegate.onTapItem(data.id)
        }
    }
}