package com.example.androidapp.network


import com.example.androidapp.model.SiteModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


interface RetroService {

    @GET("data")
    suspend fun getDataFromApi(): ArrayList<SiteModel>
}