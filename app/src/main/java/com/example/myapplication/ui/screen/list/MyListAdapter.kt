package com.example.myapplication.ui.screen.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.HolderItemBinding

class MyListAdapter(private val dataList: List<String>) : RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_item, parent, false)
        val binding = HolderItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

}


class MyViewHolder(private val binding: HolderItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(data: String) {
        binding.holderTxt.text = data
    }

}