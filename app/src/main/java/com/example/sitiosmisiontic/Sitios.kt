package com.mintic.travelappfinal

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Sitios (

    @SerializedName("cityName")
    val cityName:String,
    val largeInfo :String,
    val ubiGeo:String,
    val tempClima:String,
    val sitesRec:String,
    val shortInfo:String,
    val imageURL:String,
    val punctuation:String,
    val latitud:String,
    val longitud:String,

)