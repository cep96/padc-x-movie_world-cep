package com.cep.moviesworld.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.cep.moviesworld.data.vos.CrewVO
import com.cep.moviesworld.utils.GET_MOVIE_IMAGE
import kotlinx.android.synthetic.main.item_person.view.*

class CrewViewHolder(itemView: View) : BaseViewHolder<CrewVO>(itemView) {

    override fun bindData(data: CrewVO) {

        if (data.profilePath.isNotEmpty()){
            Glide.with(itemView)
                .load("$GET_MOVIE_IMAGE${data.profilePath}")
                .into(itemView.ivProfile)
        }

        itemView.tvActorName.text = data.name
    }
}