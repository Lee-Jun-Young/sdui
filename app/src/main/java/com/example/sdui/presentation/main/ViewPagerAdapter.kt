package com.example.sdui.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sdui.R
import com.example.sdui.data.dto.BannerBodyDto
import com.example.sdui.databinding.ItemListTypeBannerContentBinding

class ViewPagerAdapter : ListAdapter<BannerBodyDto, ViewPagerAdapter.MainViewHolder>(
    TravelDiffCallback
) {
    inner class MainViewHolder(private val binding: ItemListTypeBannerContentBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun bind(data: BannerBodyDto) = with(binding) {
            Glide.with(itemView.context)
                .load(data.bannerUrl)
                .placeholder(R.drawable.ic_bg_2)
                .into(ivSlide)
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemListTypeBannerContentBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object TravelDiffCallback : DiffUtil.ItemCallback<BannerBodyDto>() {
        override fun areItemsTheSame(
            oldItem: BannerBodyDto,
            newItem: BannerBodyDto
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: BannerBodyDto,
            newItem: BannerBodyDto
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}