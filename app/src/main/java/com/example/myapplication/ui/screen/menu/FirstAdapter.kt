package com.example.myapplication.ui.screen.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.HolderFirstViewBinding
import com.example.myapplication.databinding.HolderSecondViewBinding

class FirstAdapter(val dataList: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.holder_first_view -> {
                val binding =
                    HolderFirstViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                binding.root.setOnClickListener { view ->
                    Toast.makeText(parent.context, "Item pressed ${view.tag}", Toast.LENGTH_SHORT)
                        .show()
                }

                FirstViewHolder(binding)
            }

            R.layout.holder_second_view -> {
                val binding =
                    HolderSecondViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                binding.root.setOnClickListener { view ->
                    Toast.makeText(parent.context, "Item pressed ${view.tag}", Toast.LENGTH_SHORT)
                        .show()
                }

                SecondViewHolder(binding)
            }

            else -> {
                val binding =
                    HolderFirstViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                binding.root.setOnClickListener { view ->
                    Toast.makeText(parent.context, "Item pressed ${view.tag}", Toast.LENGTH_SHORT)
                        .show()
                }

                FirstViewHolder(binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position % 2 == 0) {
            true -> R.layout.holder_first_view

            else -> R.layout.holder_second_view
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FirstViewHolder -> holder.bind(data = dataList[position], position = position)
            is SecondViewHolder -> holder.bind(data = dataList[position], position = position)
        }
    }

    override fun getItemCount(): Int = dataList.size

//    companion object {
//        const val FIRST_VIEW_TYPE = 0
//        const val SECOND_VIEW_TYPE = 1
//    }

}

class FirstViewHolder(private val binding: HolderFirstViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(position: Int, data: String) {
        binding.root.tag = data
        binding.holderFirstTxt.text = data
    }
}

class SecondViewHolder(private val binding: HolderSecondViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(position: Int, data: String) {
        binding.root.tag = data
        binding.holderFirstTxt.text = data
    }
}