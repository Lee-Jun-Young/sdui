package com.example.sdui.presentation.main


import androidx.recyclerview.widget.RecyclerView
import com.example.sdui.data.dto.BaseBodyDto
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
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
import timber.log.Timber

class MainAdapter : ListAdapter<MainAdapter.ClassItem, RecyclerView.ViewHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<ClassItem>() {
            override fun areItemsTheSame(
                oldItem: ClassItem,
                newItem: ClassItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ClassItem,
                newItem: ClassItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    sealed class ClassItem {
        data class Card(val body: SectionCardContentDto) : ClassItem()
        data class Banner(val body: SectionBannerContentDto) : ClassItem()
        data class AppBar(val body: SectionAppBarContentDto) : ClassItem()
        data class List(val body: SectionListContentDto) : ClassItem()
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ClassItem.Card -> {
                0
            }

            is ClassItem.Banner -> {
                1
            }

            is ClassItem.AppBar -> {
                2
            }

            else -> {
                3
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                MainCardViewHolder(
                    ItemListTypeCardBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            1 -> {
                MainBannerViewHolder(
                    ItemListTypeBannerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            2 -> {
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
        val item = getItem(position)
        Timber.d("onBindViewHolder: $item")
        when (holder) {
            is MainCardViewHolder -> holder.bind((item as SectionCardContentDto))
            is MainBannerViewHolder -> holder.bind((item as SectionBannerContentDto))
            is MainAppBarViewHolder -> holder.bind((item as SectionAppBarContentDto))
            is MainListViewHolder -> holder.bind((item as SectionListContentDto))
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
        submitList(submitItem)
    }

    class MainCardViewHolder(private val binding: ItemListTypeCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SectionCardContentDto) {
            Timber.d("bind: $item")
        }
    }

    class MainBannerViewHolder(private val binding: ItemListTypeBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SectionBannerContentDto) {
            Timber.d("bind: $item")
        }
    }

    class MainAppBarViewHolder(private val binding: ItemListTypeAppBarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SectionAppBarContentDto) {
            Timber.d("bind: $item")
        }
    }

    class MainListViewHolder(private val binding: ItemListTypeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SectionListContentDto) {
            Timber.d("bind: $item")
        }
    }
}