package com.example.sdui.presentation.main

import com.bumptech.glide.Glide
import com.example.sdui.databinding.ItemListTypeCardBinding
import com.example.sdui.util.getImageRes
import com.example.sdui.util.toPriceFormat
import com.example.sdui.presentation.main.MainAdapter.TypeItem

class CardTypeViewHolder(
    private val binding: ItemListTypeCardBinding
) : CommonViewHolder(binding) {
    override fun bind(item: TypeItem) = with(binding) {
        val data = item as TypeItem.Card
        Glide.with(itemView.context).load(getImageRes(itemView.context, data.body.url!!))
            .into(ivImg)
        tvTitle.text = data.body.title
        tvDescription.text = data.body.description
        tvPrice.text = toPriceFormat(data.body.price!!)
    }
}