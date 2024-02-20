package com.example.sdui.presentation.main

import androidx.viewpager2.widget.ViewPager2
import com.example.sdui.databinding.ItemListTypeBannerBinding
import com.example.sdui.presentation.main.MainAdapter.TypeItem

class BannerTypeViewHolder(private val binding: ItemListTypeBannerBinding) :
    CommonViewHolder(binding) {
    override fun bind(item: TypeItem) = with(binding) {
        val data = item as TypeItem.Banner
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
        bannerAdapter.submitList(data.body.body)
    }
}