package com.example.myapplication.ui.screen.viewmodel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityViewModelBinding

class ViewModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewModelBinding

    private val counterViewmodel: CounterViewModel by viewModels()
    private val databaseViewmodel: DatabaseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        binding.viewmodelBtnDecrease.setOnClickListener {
            val newCounter = counterViewmodel.decreaseCounter()

            binding.viewmodelCounter.text = newCounter.toString()
        }

        binding.viewmodelBtnIncrease.setOnClickListener {
            val newCounter = counterViewmodel.increaseCounter()

            binding.viewmodelCounter.text = newCounter.toString()
        }

        binding.viewmodelCounter.text = databaseViewmodel.getLastUser()?.name ?: "No user"
    }
}