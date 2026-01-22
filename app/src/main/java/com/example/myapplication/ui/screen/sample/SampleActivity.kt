package com.example.myapplication.ui.screen.sample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.ActivitySampleBinding
import com.example.myapplication.ui.screen.sample.fragment.SampleFragment
import com.example.myapplication.ui.screen.sample.ui.SampleViewPagerAdapter
import com.example.myapplication.ui.screen.sample.viewmodel.SampleParentViewmodel

class SampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySampleBinding

    private val parentViewmodel: SampleParentViewmodel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        binding = ActivitySampleBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(binding.fragmentContainer.id, SampleFragment.newInstance())
//        transaction.commit()

        binding.sampleViewpager.adapter = SampleViewPagerAdapter(supportFragmentManager)

        parentViewmodel.streamCounter.observe(this, object : Observer<Int> {
            override fun onChanged(value: Int) {
                binding.sampleCounter.text = value.toString()
            }
        })
    }
}