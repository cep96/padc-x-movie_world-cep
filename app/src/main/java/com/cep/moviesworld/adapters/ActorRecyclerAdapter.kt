package com.cep.moviesworld.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cep.moviesworld.R
import com.cep.moviesworld.data.vos.PersonVO
import com.cep.moviesworld.views.viewholders.ActorViewHolder
import com.cep.moviesworld.views.viewholders.BestPopularFilmsAndSerialsViewHolder

class ActorRecyclerAdapter:
    BaseRecyclerAdapter<ActorViewHolder, PersonVO>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ActorViewHolder {
        return ActorViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_person, parent, false)
        )
    }
}