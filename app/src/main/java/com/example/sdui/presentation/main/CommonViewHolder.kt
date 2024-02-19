package com.example.sdui.presentation.main

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class CommonViewHolder(
    binding: ViewBinding
) : RecyclerView.ViewHolder(binding.root){
    abstract fun bind(item: MainAdapter.TypeItem)
}