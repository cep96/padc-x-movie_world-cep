package com.cep.moviesworld.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cep.moviesworld.R
import com.cep.moviesworld.data.vos.CastVO
import com.cep.moviesworld.data.vos.CrewVO
import com.cep.moviesworld.data.vos.PersonVO
import com.cep.moviesworld.views.viewholders.ActorViewHolder
import com.cep.moviesworld.views.viewholders.BestPopularFilmsAndSerialsViewHolder
import com.cep.moviesworld.views.viewholders.CastViewHolder
import com.cep.moviesworld.views.viewholders.CrewViewHolder

class CrewRecyclerAdapter:
    BaseRecyclerAdapter<CrewViewHolder, CrewVO>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrewViewHolder {
        return CrewViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_person, parent, false)
        )
    }
}