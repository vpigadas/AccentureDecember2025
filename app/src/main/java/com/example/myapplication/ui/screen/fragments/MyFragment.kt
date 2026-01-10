package com.example.myapplication.ui.screen.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentMyBinding

class MyFragment : Fragment() {

    private lateinit var binding: FragmentMyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title1 = arguments?.getString("title1", "EMPTY")
        binding.title1.text = title1

        val title2 = arguments?.getString("title2", "EMPTY")
        binding.title2.text = title2

        val title3 = arguments?.getString("title3", "EMPTY")
        binding.title3.text = title3
    }

    companion object {

        fun getInstance(
            title1: String? = null,
            title2: String? = null,
            title3: String? = null
        ): MyFragment {
            val fragment = MyFragment()

            val bundle = Bundle()
            bundle.putString("title1", title1)
            bundle.putString("title2", title2)
            bundle.putString("title3", title3)
            fragment.arguments = bundle

            return fragment
        }
    }

}