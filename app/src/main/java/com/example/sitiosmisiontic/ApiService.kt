package com.mintic.travelappfinal

import retrofit2.http.GET

interface ApiService {

    @GET("cities")
    suspend fun requestSitios(): List<Sitios>
}