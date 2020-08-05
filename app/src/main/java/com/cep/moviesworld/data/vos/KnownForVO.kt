package com.cep.moviesworld.data.vos

import com.google.gson.annotations.SerializedName

data class KnownForVO(
    @SerializedName("original_name") var originalName: String = "",
    @SerializedName("vote_count") var voteCount: Int = 0,
    @SerializedName("poster_path") var posterPath: String = "",
    @SerializedName("media_type") var mediaType: String = "",
    @SerializedName("name") var name: String = "",
    @SerializedName("vote_average") var voteAverage: Double = 0.0,
    @SerializedName("id") var id: Int = 0,
    @SerializedName("first_air_date") var firstAirDate: String = "",
    @SerializedName("original_language") var originalLanguage: String = "",
    @SerializedName("genre_ids") var genreIds: List<Int> = arrayListOf(),
    @SerializedName("backdrop_path") var backdropPath: String = "",
    @SerializedName("overview") var overview: String = "",
    @SerializedName("origin_country") var originCountry: List<String> = arrayListOf()
)