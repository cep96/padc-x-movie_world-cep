package com.cep.moviesworld.network.responses

import com.cep.moviesworld.data.vos.GenreVO
import com.cep.moviesworld.data.vos.ProductionCompanyVO
import com.cep.moviesworld.data.vos.ProductionCountryVO
import com.cep.moviesworld.data.vos.SpokenLanguageVO
import com.google.gson.annotations.SerializedName

data class GetMovieDetailsResponse (
    @SerializedName("adult") var adult: Boolean = false,
    @SerializedName("backdrop_path") var backdropPath: String = "",
    @SerializedName("belongs_to_collection") var belongsToCollection: String = "",
    @SerializedName("budget") var budget: Long = 0,
    @SerializedName("genres") var genres: ArrayList<GenreVO> = arrayListOf(),
    @SerializedName("homepage") var homePage: String = "",
    @SerializedName("id") var id: Int = 0,
    @SerializedName("imdb_id") var imdbId: String = "",
    @SerializedName("original_language") var originalLanguage: String = "",
    @SerializedName("original_title") var originalTitle: String = "",
    @SerializedName("overview") var overview: String = "",
    @SerializedName("popularity") var popularity: Double = 0.0,
    @SerializedName("poster_path") var posterPath: String = "",
    @SerializedName("production_companies") var productionCompanies: ArrayList<ProductionCompanyVO> = arrayListOf(),
    @SerializedName("production_countries") var productionCountries: ArrayList<ProductionCountryVO> = arrayListOf(),
    @SerializedName("release_date") var releaseDate: String = "",
    @SerializedName("revenue") var revenue: Int = 0,
    @SerializedName("runtime") var runtime: Int = 91,
    @SerializedName("spoken_languages") var spokenLanguages: ArrayList<SpokenLanguageVO> = arrayListOf(),
    @SerializedName("status") var status: String = "",
    @SerializedName("tagline") var tagLine: String = "",
    @SerializedName("title") var title: String = "",
    @SerializedName("video") var video: Boolean = false,
    @SerializedName("vote_average") var voteAverage: Double = 0.0,
    @SerializedName("vote_count") var voteCount: Int = 0

)