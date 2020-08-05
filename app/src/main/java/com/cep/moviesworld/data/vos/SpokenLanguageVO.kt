package com.cep.moviesworld.data.vos

import com.google.gson.annotations.SerializedName

data class SpokenLanguageVO(
    @SerializedName("iso_639_1") var iso6391: String = "",
    @SerializedName("name") var name: String = ""
)