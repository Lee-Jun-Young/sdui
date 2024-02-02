package com.example.sdui.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sdui.R
import com.example.sdui.data.dto.BaseBodyDto
import com.example.sdui.data.dto.SectionAppBarContentDto
import com.example.sdui.data.dto.SectionAppBarDto
import com.example.sdui.data.dto.SectionBannerContentDto
import com.example.sdui.data.dto.SectionBannerDto
import com.example.sdui.data.dto.SectionCardContentDto
import com.example.sdui.data.dto.SectionCardDto
import com.example.sdui.data.dto.SectionListContentDto
import com.example.sdui.data.dto.SectionListDto
import com.example.sdui.databinding.ItemListTypeAppBarBinding
import com.example.sdui.databinding.ItemListTypeBannerBinding
import com.example.sdui.databinding.ItemListTypeCardBinding
import com.example.sdui.databinding.ItemListTypeListBinding
import com.example.sdui.util.toPriceFormat

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val itemList = ArrayList<Any>()

    sealed class ClassItem {
        data class Card(val body: SectionCardContentDto) : ClassItem()
        data class Banner(val body: SectionBannerContentDto) : ClassItem()
        data class AppBar(val body: SectionAppBarContentDto) : ClassItem()
        data class List(val body: SectionListContentDto) : ClassItem()
    }

    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]) {
            is ClassItem.Card -> VIEW_TYPE_CARD
            is ClassItem.Banner -> VIEW_TYPE_BANNER
            is ClassItem.AppBar -> VIEW_TYPE_APP_BAR
            is ClassItem.List -> VIEW_TYPE_LIST
            else -> throw Exception("unknown type!!")
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_CARD -> {
                MainCardViewHolder(
                    ItemListTypeCardBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            VIEW_TYPE_BANNER -> {
                MainBannerViewHolder(
                    ItemListTypeBannerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            VIEW_TYPE_APP_BAR -> {
                MainAppBarViewHolder(
                    ItemListTypeAppBarBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                MainListViewHolder(
                    ItemListTypeListBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MainCardViewHolder -> holder.bind((itemList[position] as ClassItem.Card))
            is MainBannerViewHolder -> holder.bind((itemList[position] as ClassItem.Banner))
            is MainAppBarViewHolder -> holder.bind((itemList[position] as ClassItem.AppBar))
            is MainListViewHolder -> holder.bind((itemList[position] as ClassItem.List))
        }
    }

    fun submitListEx(list: List<BaseBodyDto>) {
        val submitItem = java.util.ArrayList<ClassItem>()
        list.forEach { result ->
            when (result.viewType) {
                "VIEW_TYPE_CARD" -> {
                    val aaa = result as SectionCardDto
                    val bbb = aaa.body as SectionCardContentDto
                    submitItem.add(ClassItem.Card(bbb))
                }

                "VIEW_TYPE_BANNER" -> {
                    val aaa = result as SectionBannerDto
                    val bbb = aaa.body as SectionBannerContentDto
                    submitItem.add(ClassItem.Banner(bbb))
                }

                "VIEW_TYPE_APP_BAR" -> {
                    val aaa = result as SectionAppBarDto
                    val bbb = aaa.body as SectionAppBarContentDto
                    submitItem.add(ClassItem.AppBar(bbb))
                }

                "VIEW_TYPE_LIST" -> {
                    val aaa = result as SectionListDto
                    val bbb = aaa.body as SectionListContentDto
                    submitItem.add(ClassItem.List(bbb))
                }
            }
        }
        itemList.addAll(submitItem)
    }

    class MainCardViewHolder(private val binding: ItemListTypeCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ClassItem.Card) = with(binding) {
            Glide.with(itemView.context)
                .load(item.body.url)
                .placeholder(R.drawable.ic_bg_1)
                .into(ivImg)
            tvTitle.text = item.body.title
            tvDescription.text = item.body.description
            tvPrice.text = toPriceFormat(item.body.price!!)
        }
    }

    class MainBannerViewHolder(private val binding: ItemListTypeBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ClassItem.Banner) {

        }
    }

    class MainAppBarViewHolder(private val binding: ItemListTypeAppBarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ClassItem.AppBar) = with(binding) {
            tvTitle.text = item.body.title
        }
    }

    class MainListViewHolder(private val binding: ItemListTypeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ClassItem.List) {

        }
    }

    companion object {
        const val VIEW_TYPE_CARD = 0
        const val VIEW_TYPE_BANNER = 1
        const val VIEW_TYPE_APP_BAR = 2
        const val VIEW_TYPE_LIST = 3
    }
}