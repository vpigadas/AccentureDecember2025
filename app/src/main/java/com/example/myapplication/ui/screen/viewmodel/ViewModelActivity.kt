package com.example.myapplication.ui.screen.viewmodel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.ActivityViewModelBinding
import com.example.myapplication.ui.screen.storage.database.UserEntity
import java.util.concurrent.Executors

class ViewModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewModelBinding

    private val counterViewmodel: CounterViewModel by viewModels()
    private val databaseViewmodel: DatabaseViewModel by viewModels()

    private val executor = Executors.newSingleThreadExecutor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        binding.viewmodelBtnDecrease.setOnClickListener {
            counterViewmodel.decreaseCounter()
        }

        binding.viewmodelBtnIncrease.setOnClickListener {
            counterViewmodel.increaseCounter()
        }

        binding.viewmodelNewUser.setOnClickListener {
            databaseViewmodel.saveUser()
        }

        databaseViewmodel.getLastUser().observe(this, object : Observer<List<UserEntity>> {
            override fun onChanged(value: List<UserEntity>) {
                binding.viewmodelCounter.text = value.size.toString()
            }
        })

        counterViewmodel.streamCounter.observe(this, object : Observer<Int> {
            override fun onChanged(value: Int) {
                binding.viewmodelCounter.text = value.toString()
            }
        })

    }
}