package com.cep.moviesworld.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cep.moviesworld.R
import com.cep.moviesworld.views.viewholders.BestPopularFilmsAndSerialsViewHolder
import com.cep.moviesworld.views.viewholders.MoviesByCategoryViewHolder

class MoviesByCategoryRecyclerAdapter:
    BaseRecyclerAdapter<MoviesByCategoryViewHolder, String>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesByCategoryViewHolder {
        return MoviesByCategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_popular_films_and_serials, parent, false)
        )
    }
}