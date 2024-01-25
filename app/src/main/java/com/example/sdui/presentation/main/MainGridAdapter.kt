package com.example.sdui.presentation.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sdui.R
import com.example.sdui.data.dto.BodyDataDto
import com.example.sdui.databinding.ItemListTypeGridBinding

class MainGridAdapter : ListAdapter<BodyDataDto, MainGridAdapter.MainViewHolder>(
    TravelDiffCallback
) {
    private lateinit var context: Context

    inner class MainViewHolder(private val binding: ItemListTypeGridBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun bind(data: BodyDataDto) {
            binding.ivImg.setImageResource(R.drawable.ic_launcher_background)
            binding.tvTitle.text = data.title
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemListTypeGridBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object TravelDiffCallback : DiffUtil.ItemCallback<BodyDataDto>() {
        override fun areItemsTheSame(
            oldItem: BodyDataDto,
            newItem: BodyDataDto
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: BodyDataDto,
            newItem: BodyDataDto
        ): Boolean {
            return oldItem.title == newItem.title
        }
    }
}