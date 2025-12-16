package com.example.myapplication.ui.screen.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.HolderFirstViewBinding

class FirstAdapter(val dataList: List<String>) : RecyclerView.Adapter<FirstViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        val binding =
            HolderFirstViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.root.setOnClickListener { view ->
            Toast.makeText(parent.context, "Item pressed ${view.tag}", Toast.LENGTH_SHORT).show()
        }
        return FirstViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.bind(data = dataList[position], position = position)
    }

    override fun getItemCount(): Int = dataList.size

}

class FirstViewHolder(private val binding: HolderFirstViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(position: Int, data: String) {
        binding.root.tag = data
        binding.holderFirstTxt.text = data
    }
}