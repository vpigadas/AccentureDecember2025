package com.example.myapplication.ui.screen.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.HolderItemBinding
import com.example.myapplication.ui.screen.network.JsonDataResponse

class CustomListAdapter() : ListAdapter<JsonDataResponse, CustomViewHolder>(MyDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = HolderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class CustomViewHolder(private val binding: HolderItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: JsonDataResponse) {
        binding.holderTxt.text = data.toString()
    }

}

class MyDiffUtil : DiffUtil.ItemCallback<JsonDataResponse>() {
    override fun areItemsTheSame(oldItem: JsonDataResponse, newItem: JsonDataResponse): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: JsonDataResponse, newItem: JsonDataResponse): Boolean =
        oldItem.compareContent(newItem)

}