package com.example.myapplication.ui.screen.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CounterViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPreferences = application.getSharedPreferences("Counter", 0)

    private val _streamCounter = MutableLiveData<Int>(0)
    val streamCounter: LiveData<Int> = _streamCounter

    init {
        val counter = sharedPreferences.getInt("counter", 0)
        _streamCounter.postValue(counter)
    }

    fun increaseCounter() {
        viewModelScope.launch(Dispatchers.Default) {
            val counter = sharedPreferences.getInt("counter", 0)

            val newCounter = counter + 1
            sharedPreferences.edit().putInt("counter", newCounter).apply()

            _streamCounter.postValue(newCounter)
        }
    }

    fun decreaseCounter() {
        viewModelScope.launch(Dispatchers.Default) {
            val counter = sharedPreferences.getInt("counter", 0)

            val newCounter = counter - 1
            sharedPreferences.edit().putInt("counter", newCounter).apply()

            _streamCounter.postValue(newCounter)
        }

    }
}