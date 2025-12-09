package com.example.myapplication.ui.screen.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityRegisterV2Binding

class RegisterV2 : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterV2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterV2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(binding.registerFragmentContainer.id, BlankFragment())
        fragmentTransaction.commit()
    }
}