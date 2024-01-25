package com.example.sdui.presentation.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sdui.data.dto.SectionItemDto
import com.example.sdui.databinding.ItemListTypeCardBinding

class MainAdapter : ListAdapter<SectionItemDto, MainAdapter.MainViewHolder>(
    TravelDiffCallback
) {
    private lateinit var context: Context

    inner class MainViewHolder(private val binding: ItemListTypeCardBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun bind(travel: SectionItemDto) {
            binding.tvType1.text = travel.header?.header
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemListTypeCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object TravelDiffCallback : DiffUtil.ItemCallback<SectionItemDto>() {
        override fun areItemsTheSame(
            oldItem: SectionItemDto,
            newItem: SectionItemDto
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: SectionItemDto,
            newItem: SectionItemDto
        ): Boolean {
            return oldItem.viewType == newItem.viewType
        }
    }
}