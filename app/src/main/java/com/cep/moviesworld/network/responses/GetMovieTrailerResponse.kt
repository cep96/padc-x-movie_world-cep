package com.cep.moviesworld.network.responses

import com.cep.moviesworld.data.vos.MovieTrailerVO
import com.google.gson.annotations.SerializedName

data class GetMovieTrailerResponse(
    @SerializedName("id") var id: Int,
    @SerializedName("results") var results: ArrayList<MovieTrailerVO>

)
