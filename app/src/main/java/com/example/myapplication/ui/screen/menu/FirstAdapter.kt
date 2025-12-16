package com.example.myapplication.ui.screen.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.HolderFirstViewBinding

class FirstAdapter(val dataList: List<String>) : RecyclerView.Adapter<FirstViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        val binding =
            HolderFirstViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FirstViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

}

class FirstViewHolder(private val binding: HolderFirstViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: String){
        binding.holderFirstTxt.text = data
    }
}