package com.example.myapplication.ui.screen.sample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySampleBinding
import com.example.myapplication.ui.screen.sample.fragment.SampleFragment

class SampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySampleBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.fragmentContainer.id, SampleFragment.newInstance())
        transaction.commit()
    }
}