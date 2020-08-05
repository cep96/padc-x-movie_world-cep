package com.cep.moviesworld.data.vos

import com.google.gson.annotations.SerializedName

data class ProductionCountryVO(
    @SerializedName("iso_3166_1") var iso31661: String = "",
    @SerializedName("name") var name: String = ""
)