package com.example.sdui.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sdui.R
import com.example.sdui.data.dto.DesignDto
import com.example.sdui.data.dto.ListBodyDto
import com.example.sdui.databinding.ItemListTypeListBinding
import com.example.sdui.util.toPriceFormat

class HorizontalScrollAdapter(private val design: DesignDto) :
    ListAdapter<ListBodyDto, HorizontalScrollAdapter.ListViewHolder>(
        TravelDiffCallback
    ) {

    inner class ListViewHolder(private val binding: ItemListTypeListBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun bind(data: ListBodyDto) {
            val params = ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(
                design.left,
                design.top,
                design.right,
                design.bottom
            )
            binding.root.layoutParams = params

            Glide.with(itemView.context)
                .load(data.url)
                .placeholder(R.drawable.ic_bg_1)
                .into(binding.ivImg)

            binding.tvPrice.text = toPriceFormat(data.price!!)
            binding.tvTitle.text = data.title
            binding.tvRate.text = data.rate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListTypeListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object TravelDiffCallback : DiffUtil.ItemCallback<ListBodyDto>() {
        override fun areItemsTheSame(oldItem: ListBodyDto, newItem: ListBodyDto): Boolean {
            return oldItem == newItem
        }

        // id 로 비교
        override fun areContentsTheSame(oldItem: ListBodyDto, newItem: ListBodyDto): Boolean {
            return oldItem.id == newItem.id
        }
    }
}