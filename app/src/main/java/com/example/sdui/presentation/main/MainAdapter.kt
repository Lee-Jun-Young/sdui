package com.example.sdui.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
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
import com.example.sdui.databinding.ItemListTypeBinding
import com.example.sdui.databinding.ItemListTypeCardBinding
import com.example.sdui.util.getImageRes
import com.example.sdui.util.toPriceFormat

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val itemList = ArrayList<ClassItem>()

    sealed class ClassItem(private val viewType: ViewType) {
        data class Card(val body: SectionCardContentDto) : ClassItem(ViewType.VIEW_TYPE_CARD)
        data class Banner(val body: SectionBannerContentDto) : ClassItem(ViewType.VIEW_TYPE_BANNER)
        data class AppBar(val body: SectionAppBarContentDto) : ClassItem(ViewType.VIEW_TYPE_APP_BAR)
        data class List(val body: SectionListContentDto) : ClassItem(ViewType.VIEW_TYPE_LIST)

        fun getViewType() = viewType
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].getViewType().ordinal
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (ViewType.values()[viewType]) {
            ViewType.VIEW_TYPE_CARD -> {
                MainCardViewHolder(
                    ItemListTypeCardBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            ViewType.VIEW_TYPE_BANNER -> {
                MainBannerViewHolder(
                    ItemListTypeBannerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            ViewType.VIEW_TYPE_APP_BAR -> {
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
                    ItemListTypeBinding.inflate(
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
            when (ViewType.valueOf(result.viewType)) {
                ViewType.VIEW_TYPE_CARD -> {
                    val temp = (result as SectionCardDto).body as SectionCardContentDto
                    submitItem.add(ClassItem.Card(temp))
                }

                ViewType.VIEW_TYPE_BANNER -> {
                    val temp = (result as SectionBannerDto).body as SectionBannerContentDto
                    submitItem.add(ClassItem.Banner(temp))
                }

                ViewType.VIEW_TYPE_APP_BAR -> {
                    val temp = (result as SectionAppBarDto).body as SectionAppBarContentDto
                    submitItem.add(ClassItem.AppBar(temp))
                }

                ViewType.VIEW_TYPE_LIST -> {
                    val temp = (result as SectionListDto).body as SectionListContentDto
                    submitItem.add(ClassItem.List(temp))
                }
            }
        }
        itemList.addAll(submitItem)
    }

    class MainCardViewHolder(private val binding: ItemListTypeCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ClassItem.Card) = with(binding) {
            Glide.with(itemView.context)
                .load(getImageRes(itemView.context, item.body.url!!))
                .into(ivImg)
            tvTitle.text = item.body.title
            tvDescription.text = item.body.description
            tvPrice.text = toPriceFormat(item.body.price!!)
        }
    }

    class MainBannerViewHolder(private val binding: ItemListTypeBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ClassItem.Banner) = with(binding) {
            val bannerAdapter = ViewPagerAdapter()
            vpBanner.adapter = bannerAdapter

            vpBanner.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    vpBanner.postDelayed({
                        if (vpBanner.currentItem < bannerAdapter.itemCount - 1) {
                            vpBanner.currentItem = vpBanner.currentItem + 1
                        } else {
                            vpBanner.currentItem = 0
                        }
                    }, 3000)
                }
            })

            bannerAdapter.submitList(item.body.body)
        }
    }

    class MainAppBarViewHolder(private val binding: ItemListTypeAppBarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ClassItem.AppBar) = with(binding) {
            tvTitle.text = item.body.title
        }
    }

    class MainListViewHolder(private val binding: ItemListTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ClassItem.List) {
            val adapter = HorizontalScrollAdapter(item.body.design!!)
            adapter.submitList(item.body.body)
            binding.rvList.layoutManager =
                androidx.recyclerview.widget.LinearLayoutManager(
                    binding.root.context,
                    RecyclerView.HORIZONTAL,
                    false
                )
            binding.rvList.adapter = adapter
        }
    }

    enum class ViewType {
        VIEW_TYPE_CARD, VIEW_TYPE_BANNER, VIEW_TYPE_APP_BAR, VIEW_TYPE_LIST
    }
}