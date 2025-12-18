package com.example.myapplication.ui.screen.menu

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMenuBinding


class MenuActivity : AppCompatActivity() {

    private var buttonPressed: Boolean = false

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.menuRecycler.adapter =
            FirstAdapter((1..50).map { it.toString() }, listener = { view ->
                when (buttonPressed) {
                    false -> {
                        buttonPressed = true

                        val toast = Toast.makeText(
                            baseContext,
                            "Item pressed ${view.tag} !!!",
                            Toast.LENGTH_LONG
                        )

                        toast.addCallback(object : Toast.Callback() {
                            override fun onToastHidden() {
                                super.onToastHidden()
                                buttonPressed = false
                            }
                        })

                        toast.show()
                    }

                    true -> Unit
                }

            })

    }

}