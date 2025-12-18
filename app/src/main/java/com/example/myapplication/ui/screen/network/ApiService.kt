package com.example.myapplication.ui.screen.network

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @GET("breeds")
    @Headers("Accept: application/json")
    fun getAllDogs(): Call<JsonElement>

}