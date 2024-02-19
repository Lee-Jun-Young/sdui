package com.example.sdui.presentation.main

import androidx.recyclerview.widget.RecyclerView
import com.example.sdui.databinding.ItemListTypeBinding

class ListTypeViewHolder(
    private val binding: ItemListTypeBinding
) : CommonViewHolder(binding) {
    override fun bind(item: MainAdapter.TypeItem) = with(binding) {
        val result = item as MainAdapter.TypeItem.List
        val adapter = HorizontalScrollAdapter(result.body.design!!)
        adapter.submitList(result.body.body)
        binding.rvList.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
            binding.root.context, RecyclerView.HORIZONTAL, false
        )
        binding.rvList.adapter = adapter
    }
}