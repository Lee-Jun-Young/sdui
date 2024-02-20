package com.example.sdui.presentation.main.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding
import com.example.sdui.R
import com.example.sdui.presentation.ViewType

object CommonViewHolderFactory {
    fun createViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        return when (viewType) {
            ViewType.VIEW_TYPE_CARD.ordinal -> CardTypeViewHolder(
                getViewDataBinding(
                    parent,
                    R.layout.item_list_type_card
                )
            )

            ViewType.VIEW_TYPE_BANNER.ordinal -> BannerTypeViewHolder(
                getViewDataBinding(
                    parent,
                    R.layout.item_list_type_banner
                )
            )

            else -> ListTypeViewHolder(
                getViewDataBinding(
                    parent,
                    R.layout.item_list_type
                )
            )
        }
    }

    private fun <T : ViewBinding> getViewDataBinding(parent: ViewGroup, layoutRes: Int): T {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutRes,
            parent,
            false
        )
    }
}