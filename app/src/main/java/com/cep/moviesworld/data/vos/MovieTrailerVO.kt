package com.cep.moviesworld.data.vos

import com.google.gson.annotations.SerializedName

data class MovieTrailerVO(
    @SerializedName("id") var id: String = "",
    @SerializedName("iso_639_1") var iso6391 : String = "",
    @SerializedName("iso_3166_1") var iso31661: String = "",
    @SerializedName("key") var key: String = "",
    @SerializedName("name") var name: String = "",
    @SerializedName("site") var site: String = "",
    @SerializedName("size") var size: Int = 0,
    @SerializedName("type") var type: String = ""
)