package com.cep.moviesworld.persistence.typeconverters

import androidx.room.TypeConverter
import com.cep.moviesworld.data.vos.KnownForVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class KnownForTypeConverter {

    @TypeConverter
    fun toString(knownFor: List<KnownForVO>): String{
        return Gson().toJson(knownFor)
    }

    @TypeConverter
    fun toKnownForList(knownForListStr: String): ArrayList<KnownForVO>{
        val knownForType = object : TypeToken<ArrayList<KnownForVO>>(){}.type
        return Gson().fromJson(knownForListStr, knownForType)
    }
}