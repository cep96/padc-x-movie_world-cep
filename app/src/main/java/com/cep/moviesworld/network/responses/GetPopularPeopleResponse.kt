package com.cep.moviesworld.network.responses

import com.cep.moviesworld.data.vos.PersonVO
import com.google.gson.annotations.SerializedName

data class GetPopularPeopleResponse(
    @SerializedName("page") var page: Int = 0,
    @SerializedName("total_results") var totalResult: Int = 0,
    @SerializedName("total_pages") var totalPages: Int = 0,
    @SerializedName("results") var results: List<PersonVO>
)