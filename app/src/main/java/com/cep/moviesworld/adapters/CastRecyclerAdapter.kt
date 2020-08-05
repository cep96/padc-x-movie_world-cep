package com.cep.moviesworld.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cep.moviesworld.R
import com.cep.moviesworld.data.vos.CastVO
import com.cep.moviesworld.data.vos.PersonVO
import com.cep.moviesworld.views.viewholders.ActorViewHolder
import com.cep.moviesworld.views.viewholders.BestPopularFilmsAndSerialsViewHolder
import com.cep.moviesworld.views.viewholders.CastViewHolder

class CastRecyclerAdapter:
    BaseRecyclerAdapter<CastViewHolder, CastVO>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CastViewHolder {
        return CastViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_person, parent, false)
        )
    }
}