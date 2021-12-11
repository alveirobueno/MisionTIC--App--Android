package com.example.androidapp.model

import com.google.gson.annotations.SerializedName

data class SiteModel(
    @SerializedName("_id")          val _id: String,
    @SerializedName("cityName")     val cityName: String,
    @SerializedName("largeInfo")    val largeInfo: String,
    @SerializedName("ubiGeo")       val ubiGeo: String,
    @SerializedName("tempClima")    val tempClima: String,
    @SerializedName("sitesRec")     val sitesRec: String,
    @SerializedName("shortInfo")    val shortInfo: String,
    @SerializedName("imageURL")     val imageURL: String,
    @SerializedName("punctuation")  val punctuation: String,
)