package com.example.myapplication.ui.screen.sample.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SampleParentViewmodel : ViewModel() {

    private val _streamCounter = MutableLiveData<Int>(0)
    val streamCounter: LiveData<Int> = _streamCounter

    fun updateCounter(counter: Int) {
        Log.d("ViewModel", "updateCounter: $counter")
        _streamCounter.postValue(counter)
    }
}