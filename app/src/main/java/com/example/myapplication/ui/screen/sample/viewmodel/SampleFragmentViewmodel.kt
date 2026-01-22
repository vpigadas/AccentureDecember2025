package com.example.myapplication.ui.screen.sample.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.ui.screen.sample.ui.SampleAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SampleFragmentViewmodel(application: Application) : AndroidViewModel(application) {

    val adapter: SampleAdapter = SampleAdapter()

    fun onResume() {
        viewModelScope.launch {

            val repeatableJob = async {
                runOperation("Repeatable", 3000)
            }

            repeatableJob.onAwait

            launch {
                runOperation("First", 1000)
            }
            launch {
                runOperation("Second", 3000)
            }
            launch {
                runOperation("Third", 500)
            }
        }
    }

    suspend fun runOperation(name: String, delay: Long) {
        withContext(Dispatchers.Default) {
            Log.i("Viewmodel", "$name operation start")
            delay(delay)
            Log.i("Viewmodel", "$name operation end")
        }
    }
}