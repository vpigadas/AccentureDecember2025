package com.example.myapplication.ui.screen.storage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.myapplication.databinding.ActivityStorageBinding

class StorageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStorageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStorageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.storageBtnUp.setOnClickListener {
            val counter = getSharedPreferences("datastore", MODE_PRIVATE)
                .getInt("counter", 0)

            getSharedPreferences("datastore", MODE_PRIVATE).edit {
                putInt("counter", counter + 1)
            }

            updateUi()
        }

        binding.storageBtnDown.setOnClickListener {
            val counter = getSharedPreferences("datastore", MODE_PRIVATE)
                .getInt("counter", 0)

            getSharedPreferences("datastore", MODE_PRIVATE)
                .edit().putInt("counter", counter - 1).apply()

            updateUi()
        }


        updateUi()
    }

    fun updateUi() {
        val counter = getSharedPreferences("datastore", MODE_PRIVATE)
            .getInt("counter", 0)

        binding.storageTxtValue.text = counter.toString()
    }
}