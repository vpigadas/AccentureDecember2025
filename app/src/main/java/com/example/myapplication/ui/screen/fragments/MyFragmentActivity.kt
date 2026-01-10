package com.example.myapplication.ui.screen.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMyFragmentBinding

class MyFragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyFragmentBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


        val title1 = "Vassilis"
        val title2 = "Pigadas"
        val title3 = "Markos"

        val fragment = MyFragment.getInstance(title1,title2,title3)
//        val fragment = MyFragment.getInstance(title2 = title2)
//        val fragment = MyFragment.getInstance(title1 = title1,title3 = title3)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(
            binding.fragmentContainer.id,
            fragment,
            MyFragment::class.simpleName
        )
        fragmentTransaction.commit()

        binding.fragmentContainer
    }
}