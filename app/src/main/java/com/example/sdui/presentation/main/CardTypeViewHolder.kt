package com.example.sdui.presentation.main

import com.bumptech.glide.Glide
import com.example.sdui.databinding.ItemListTypeCardBinding
import com.example.sdui.util.getImageRes
import com.example.sdui.util.toPriceFormat

class CardTypeViewHolder(
    private val binding: ItemListTypeCardBinding
) : CommonViewHolder(binding) {
    override fun bind(data: MainAdapter.TypeItem) = with(binding) {
        val item = data as MainAdapter.TypeItem.Card
        Glide.with(itemView.context).load(getImageRes(itemView.context, item.body.url!!))
            .into(ivImg)
        tvTitle.text = item.body.title
        tvDescription.text = item.body.description
        tvPrice.text = toPriceFormat(item.body.price!!)
    }
}