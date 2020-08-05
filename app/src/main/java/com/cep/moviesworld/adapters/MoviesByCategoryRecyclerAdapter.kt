package com.cep.moviesworld.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cep.moviesworld.R
import com.cep.moviesworld.data.vos.ResultsVO
import com.cep.moviesworld.views.viewholders.MoviesByCategoryViewHolder
import com.cep.moviesworld.views.viewpods.PopularFilmsAndSerialsViewPod

class MoviesByCategoryRecyclerAdapter(
    private val delegate: PopularFilmsAndSerialsViewPod.Delegate):
    BaseRecyclerAdapter<MoviesByCategoryViewHolder, ResultsVO>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesByCategoryViewHolder {
        return MoviesByCategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_popular_films_and_serials, parent, false),
            delegate
        )
    }
}