package com.cep.moviesworld.network.responses

import com.cep.moviesworld.data.vos.GenreVO
import com.google.gson.annotations.SerializedName

data class GenresResponse(
    @SerializedName("genres") var genres: List<GenreVO> = arrayListOf()
)