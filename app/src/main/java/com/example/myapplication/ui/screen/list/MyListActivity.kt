package com.example.myapplication.ui.screen.list

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMyListBinding
import com.example.myapplication.ui.screen.network.ApiService
import com.example.myapplication.ui.screen.network.JsonResponse
import com.example.myapplication.ui.screen.network.NetworkActivity
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyListBinding
    private val adapter = CustomListAdapter()

    private val gson: Gson = GsonBuilder().setLenient().create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMyListBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        binding.myListRecyclerView.adapter = adapter

        binding.myListBtn.setOnClickListener {
            retrieveApiData()
        }
    }

    private fun retrieveApiData() {
        val retrofitInstance = Retrofit.Builder().baseUrl("https://dogapi.dog/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
        val apiService = retrofitInstance.create<ApiService>(ApiService::class.java)

        apiService.getAllDogsV2().enqueue(object : Callback<JsonResponse> {
            override fun onResponse(
                call: Call<JsonResponse>,
                response: Response<JsonResponse>
            ) {
                Log.d(NetworkActivity::class.simpleName, "response code: ${response.code()}")
                Log.d(NetworkActivity::class.simpleName, response.body().toString())

                val jsonResponse = response.body()?.data ?: emptyList()

                adapter.submitList(jsonResponse.shuffled())
            }

            override fun onFailure(call: Call<JsonResponse>, t: Throwable) {
                Log.e(NetworkActivity::class.simpleName, t.message, t)
            }

        })
    }
}