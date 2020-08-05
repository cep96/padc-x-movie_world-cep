package com.cep.moviesworld.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "person")
data class PersonVO(
    @SerializedName("popularity") var popularity: Double = 0.0,
    @SerializedName("known_for_department") var knownForDepartment: String = "",
    @SerializedName("gender") var gender: Int = 0,
    @PrimaryKey
    @SerializedName("id") var id: Int = 0,
    @SerializedName("profile_path") var profilePath: String,
    @SerializedName("adult") var adult: Boolean,
    @SerializedName("known_for") var knownFor: ArrayList<KnownForVO> = arrayListOf(),
    @SerializedName("name") var name: String = ""
)