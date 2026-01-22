package com.example.myapplication.ui.screen.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.ui.screen.fragments.MyFragmentActivity
import com.example.myapplication.ui.screen.list.MyListActivity
import com.example.myapplication.ui.screen.menu.MenuActivity
import com.example.myapplication.ui.screen.network.NetworkActivity
import com.example.myapplication.ui.screen.register.RegisterActivity
import com.example.myapplication.ui.screen.register.RegisterV2
import com.example.myapplication.ui.screen.sample.SampleActivity
import com.example.myapplication.ui.screen.storage.StorageActivity
import com.example.myapplication.ui.screen.storage.database.DbActivity
import com.example.myapplication.ui.screen.viewmodel.ViewModelActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityLoginBinding

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

            val intent = Intent(this@LoginActivity, MenuActivity::class.java)
            startActivity(intent)
        }

        _binding.loginBtnFour.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterV2::class.java)
            startActivity(intent)
        }

        _binding.loginBtnOneToThree.setOnClickListener {
            val intent = Intent(this@LoginActivity, NetworkActivity::class.java)
            startActivity(intent)
        }

        _binding.loginBtnNetworkWithList.setOnClickListener {
            val intent = Intent(this@LoginActivity, MyListActivity::class.java)
            startActivity(intent)
        }

        _binding.loginBtnFragments.setOnClickListener {
            val intent = Intent(this@LoginActivity, MyFragmentActivity::class.java)
            startActivity(intent)
        }

        _binding.loginBtnStroage.setOnClickListener {
            val intent = Intent(this@LoginActivity, StorageActivity::class.java)
            startActivity(intent)
        }
        _binding.loginBtnDatabase.setOnClickListener {
            val intent = Intent(this@LoginActivity, DbActivity::class.java)
            startActivity(intent)
        }

        _binding.loginBtnViewmodel.setOnClickListener {
            val intent = Intent(this@LoginActivity, ViewModelActivity::class.java)
            startActivity(intent)
        }

        _binding.loginBtnSample.setOnClickListener {
            val intent = Intent(this@LoginActivity, SampleActivity::class.java)
            startActivity(intent)
        }
    }
}