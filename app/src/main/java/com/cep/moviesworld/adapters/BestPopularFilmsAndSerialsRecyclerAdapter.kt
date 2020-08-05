package com.cep.moviesworld.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cep.moviesworld.R
import com.cep.moviesworld.data.vos.ResultsVO
import com.cep.moviesworld.delegates.MovieItemDelegate
import com.cep.moviesworld.views.viewholders.BestPopularFilmsAndSerialsViewHolder
import com.cep.moviesworld.views.viewpods.PopularFilmsAndSerialsViewPod

class BestPopularFilmsAndSerialsRecyclerAdapter(
    private val delegate: PopularFilmsAndSerialsViewPod.Delegate
):
    BaseRecyclerAdapter<BestPopularFilmsAndSerialsViewHolder, ResultsVO>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BestPopularFilmsAndSerialsViewHolder {
        return BestPopularFilmsAndSerialsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_popular_films_and_serials, parent, false),
            delegate
        )
    }
}