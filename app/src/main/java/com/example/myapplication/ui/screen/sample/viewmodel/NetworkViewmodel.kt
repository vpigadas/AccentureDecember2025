package com.example.myapplication.ui.screen.sample.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.feature.HostException
import com.example.myapplication.ui.screen.network.JsonResponse
import com.example.myapplication.ui.screen.sample.api.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkViewmodel : ViewModel() {
    private val apiService: ApiService

    private val _streamData = MutableLiveData<JsonResponse?>()
    val streamData: LiveData<JsonResponse?> = _streamData

    init {
        val gson: Gson = GsonBuilder().setLenient().create()

        val retrofitInstance = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson)).build()

        apiService = retrofitInstance.create<ApiService>(ApiService::class.java)
    }

    fun getAllDogs() {
        viewModelScope.launch {

            runCatching {
                apiService.getAllDogsV2().enqueue(object : Callback<JsonResponse> {
                    override fun onResponse(
                        call: Call<JsonResponse?>, response: Response<JsonResponse?>
                    ) {
                        _streamData.postValue(response.body())
                    }

                    override fun onFailure(
                        call: Call<JsonResponse?>, t: Throwable
                    ) {
                        _streamData.postValue(null)
                    }
                })
            }.onFailure {
                Log.e("NetworkViewmodel", "Error: ${it.message}",it)
                _streamData.postValue(null)
            }
        }
    }

    companion object {
        private const val BASE_URL = "https://dogapi.dog/api/v2/"
    }
}