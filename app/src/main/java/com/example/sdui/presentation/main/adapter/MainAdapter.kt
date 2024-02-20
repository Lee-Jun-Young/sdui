package com.example.sdui.presentation.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sdui.data.dto.BaseBodyDto
import com.example.sdui.data.dto.SectionBannerDto
import com.example.sdui.data.dto.SectionCardDto
import com.example.sdui.data.dto.SectionListDto
import com.example.sdui.presentation.ViewType
import com.example.sdui.presentation.main.viewHolder.CommonViewHolder
import com.example.sdui.presentation.main.viewHolder.CommonViewHolderFactory

class MainAdapter : RecyclerView.Adapter<CommonViewHolder>() {
    private val itemList = ArrayList<TypeItem>()

    sealed class TypeItem(private val viewType: ViewType) {
        data class Card(val body: SectionCardDto) : TypeItem(ViewType.VIEW_TYPE_CARD)
        data class Banner(val body: SectionBannerDto) : TypeItem(ViewType.VIEW_TYPE_BANNER)
        data class List(val body: SectionListDto) : TypeItem(ViewType.VIEW_TYPE_LIST)

        fun getViewType() = viewType
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].getViewType().ordinal
    }

    override fun getItemCount(): Int = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        return CommonViewHolderFactory.createViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    fun submitListEx(list: List<BaseBodyDto>) {
        val submitItem = java.util.ArrayList<TypeItem>()
        list.forEach { result ->
            when (ViewType.valueOf(result.viewType)) {
                ViewType.VIEW_TYPE_CARD -> {
                    val temp = (result as SectionCardDto)
                    submitItem.add(TypeItem.Card(temp))
                }

                ViewType.VIEW_TYPE_BANNER -> {
                    val temp = (result as SectionBannerDto)
                    submitItem.add(TypeItem.Banner(temp))
                }

                ViewType.VIEW_TYPE_LIST -> {
                    val temp = (result as SectionListDto)
                    submitItem.add(TypeItem.List(temp))
                }
            }
        }
        itemList.addAll(submitItem)
    }

}