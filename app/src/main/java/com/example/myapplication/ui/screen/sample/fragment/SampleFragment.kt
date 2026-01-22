package com.example.myapplication.ui.screen.sample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.FragmentSampleBinding
import com.example.myapplication.ui.screen.network.JsonResponse
import com.example.myapplication.ui.screen.sample.viewmodel.NetworkViewmodel
import com.example.myapplication.ui.screen.sample.viewmodel.SampleFragmentViewmodel
import com.example.myapplication.ui.screen.sample.viewmodel.SampleParentViewmodel

class SampleFragment : Fragment() {

    private lateinit var binding: FragmentSampleBinding

    private val viewmodel: SampleFragmentViewmodel by viewModels()
    private val parentViewmodel: SampleParentViewmodel by viewModels()
    private val networkViewmodel: NetworkViewmodel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSampleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        networkViewmodel.streamData.observe(viewLifecycleOwner, object : Observer<JsonResponse?> {
            override fun onChanged(value: JsonResponse?) {
                when (value) {
                    is JsonResponse -> {
                        viewmodel.adapter.submitList(value.data)
                    }
                }
            }
        })

        binding.sampleRecyclerView.adapter = viewmodel.adapter
    }

    override fun onResume() {
        super.onResume()


        viewmodel.onResume()
        networkViewmodel.getAllDogs()
    }

    companion object {
        @JvmStatic
        fun newInstance() = SampleFragment()
    }
}