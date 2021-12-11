package com.example.androidapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object{

        private const val dataBaseUrl = "https://us-east-1.aws.data.mongodb-api.com/app/cities-fkkaa/endpoint/"

        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(dataBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}