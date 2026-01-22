package com.example.myapplication.ui.screen.sample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSecond2Binding
import com.example.myapplication.ui.screen.network.JsonResponse
import com.example.myapplication.ui.screen.sample.viewmodel.NetworkViewmodel
import kotlin.getValue

class SecondFragment : Fragment() {

    private val networkViewmodel: NetworkViewmodel by activityViewModels()
    private lateinit var binding: FragmentSecond2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecond2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        networkViewmodel.streamData.observe(viewLifecycleOwner, object: Observer<JsonResponse?>{
            override fun onChanged(value: JsonResponse?) {
                binding.secondTxt.text = value.toString()
            }
        })


    }

    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
}