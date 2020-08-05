package com.cep.moviesworld.network.responses

import com.cep.moviesworld.data.vos.DatesVO
import com.cep.moviesworld.data.vos.ResultsVO
import com.google.gson.annotations.SerializedName

data class GetMovieUpcomingResponse(
    @SerializedName("results") var results: ArrayList<ResultsVO>,
    @SerializedName("page") var page: Int,
    @SerializedName("total_results") var totalResults: Int,
    @SerializedName("dates") var dates: DatesVO,
    @SerializedName("total_pages") var totalPages: Int
)