package com.cep.moviesworld.data.vos

import com.google.gson.annotations.SerializedName

data class DatesVO (
    @SerializedName("maximum") var maximun : String ="",
    @SerializedName("minimum") var minimun: String = ""
)