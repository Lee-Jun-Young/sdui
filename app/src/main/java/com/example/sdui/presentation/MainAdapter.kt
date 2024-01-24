package com.example.sdui.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sdui.data.SectionItemDto
import com.example.sdui.databinding.ItemListTypeOneBinding

class MainAdapter : ListAdapter<SectionItemDto, MainAdapter.MainViewHolder>(
    TravelDiffCallback
) {
    private lateinit var context: Context

    inner class MainViewHolder(private val binding: ItemListTypeOneBinding) :
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
        val binding = ItemListTypeOneBinding.inflate(
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

        // id 로 비교
        override fun areContentsTheSame(
            oldItem: SectionItemDto,
            newItem: SectionItemDto
        ): Boolean {
            return oldItem.viewType == newItem.viewType
        }
    }
}