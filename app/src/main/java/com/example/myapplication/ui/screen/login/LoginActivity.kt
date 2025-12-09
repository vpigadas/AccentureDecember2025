package com.example.myapplication.ui.screen.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.ui.screen.register.RegisterActivity
import com.example.myapplication.ui.screen.register.RegisterV2

class LoginActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(_binding.root)

        _binding.loginBtnOne.setOnClickListener {
            _binding.loginTxtSample.visibility = View.GONE
        }

        _binding.loginBtnTwo.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        _binding.loginBtnThree.setOnClickListener {
            _binding.loginTxtSample.visibility = View.VISIBLE

        }

        _binding.loginBtnFour.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterV2::class.java)
            startActivity(intent)
        }
    }
}