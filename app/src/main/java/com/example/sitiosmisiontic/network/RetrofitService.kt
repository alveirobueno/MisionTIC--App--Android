package com.example.sitiosmisiontic.network

import com.example.androidapp.model.SiteModel
import retrofit2.http.GET

interface RetrofitService {

    @GET("6dff4f26-33ae-4810-9528-0af3f3ef65a7")
    suspend fun getDataFromApi(): SiteModel
}