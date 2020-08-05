package com.cep.moviesworld.network.responses

import com.cep.moviesworld.data.vos.CastVO
import com.cep.moviesworld.data.vos.CrewVO
import com.google.gson.annotations.SerializedName

data class GetMovieCastAndCrewResponse(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("cast") var cast: List<CastVO> = arrayListOf(),
    @SerializedName("crew") var crew: List<CrewVO> = arrayListOf()
)