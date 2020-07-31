package com.cep.moviesworld.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cep.moviesworld.R
import com.cep.moviesworld.views.viewholders.BestPopularFilmsAndSerialsViewHolder
import com.cep.moviesworld.views.viewholders.ShowcasesViewHolder

class ShowcasesRecyclerAdapter:
    BaseRecyclerAdapter<ShowcasesViewHolder, String>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShowcasesViewHolder {
        return ShowcasesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_showcase, parent, false)
        )
    }
}