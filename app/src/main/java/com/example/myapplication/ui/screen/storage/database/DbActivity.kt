package com.example.myapplication.ui.screen.storage.database

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDbBinding

class DbActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDbBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val appDbInstance:AppDbInstance = Room.databaseBuilder(this, AppDbInstance::class.java,"Database")
            .allowMainThreadQueries()
            .build()

        appDbInstance.getUserDao().readAll()
    }
}