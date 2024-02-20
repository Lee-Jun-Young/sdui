package com.example.sdui.presentation.main.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.sdui.databinding.ItemListTypeBinding
import com.example.sdui.presentation.main.adapter.HorizontalScrollAdapter
import com.example.sdui.presentation.main.adapter.MainAdapter.TypeItem

class ListTypeViewHolder(
    private val binding: ItemListTypeBinding
) : CommonViewHolder(binding) {
    override fun bind(item: TypeItem) = with(binding) {
        val data = item as TypeItem.List
        val adapter = HorizontalScrollAdapter(data.body.design!!)
        adapter.submitList(data.body.body)
        binding.rvList.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
            binding.root.context, RecyclerView.HORIZONTAL, false
        )
        binding.rvList.adapter = adapter
    }
}