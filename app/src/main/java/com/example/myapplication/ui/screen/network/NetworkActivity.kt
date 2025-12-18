package com.example.myapplication.ui.screen.network

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityNetworkBinding
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNetworkBinding

    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetworkBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val retrofitInstance = Retrofit.Builder().baseUrl("https://dogapi.dog/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
        val apiService = retrofitInstance.create<ApiService>(ApiService::class.java)

        apiService.getAllDogs().enqueue(object : Callback<JsonElement> {
            override fun onResponse(
                call: Call<JsonElement>,
                response: Response<JsonElement>
            ) {
                Log.d(NetworkActivity::class.simpleName, "response code: ${response.code()}")
                Log.d(NetworkActivity::class.simpleName, response.body().toString())
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.e(NetworkActivity::class.simpleName, t.message, t)
            }

        })

    }
}