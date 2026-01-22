package com.example.myapplication.ui.screen.sample.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.HolderSampleViewBinding
import com.example.myapplication.ui.screen.network.JsonDataResponse

class SampleAdapter() : ListAdapter<JsonDataResponse, SampleViewHolder>(SampleDiffUtils()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SampleViewHolder {
        val binding =
            HolderSampleViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SampleViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: SampleViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

}

class SampleViewHolder(private val binding: HolderSampleViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: JsonDataResponse) {
        binding.holderTxt.text = item.id ?: "empty value"
    }
}

class SampleDiffUtils : DiffUtil.ItemCallback<JsonDataResponse>() {
    override fun areItemsTheSame(
        oldItem: JsonDataResponse, newItem: JsonDataResponse
    ): Boolean = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: JsonDataResponse, newItem: JsonDataResponse
    ): Boolean = oldItem.equalsContent(newItem)
}
