package com.example.androidapp.model

import com.google.gson.annotations.SerializedName

data class SiteModel(val cities : ArrayList<SiteData>)
data class SiteData(
    @SerializedName("cityName") val cityName: String,
    @SerializedName("imageURL") val imageURL: String,
    @SerializedName("largeInfo") val largeInfo: String,
    @SerializedName("punctuation") val punctuation: String,
    @SerializedName("shortInfo") val shortInfo: String,
    @SerializedName("sitesRec") val sitesRec: String,
    @SerializedName("tempClima") val tempClima: String,
    @SerializedName("ubiGeo") val ubiGeo: String
)