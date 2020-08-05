package com.cep.moviesworld.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.cep.moviesworld.data.vos.PersonVO
import com.cep.moviesworld.utils.GET_MOVIE_IMAGE
import kotlinx.android.synthetic.main.item_person.view.*

class ActorViewHolder(itemView: View) : BaseViewHolder<PersonVO>(itemView) {

    override fun bindData(data: PersonVO) {
        Glide.with(itemView)
            .load("$GET_MOVIE_IMAGE${data.profilePath}")
            .into(itemView.ivProfile)

        itemView.tvActorName.text = data.name
    }
}