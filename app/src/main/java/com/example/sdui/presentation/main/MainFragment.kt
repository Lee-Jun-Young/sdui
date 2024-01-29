package com.example.sdui.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.sdui.data.dto.SectionItemDto
import com.example.sdui.databinding.FragmentMainBinding
import com.example.sdui.presentation.toPx
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel by viewModels<MainViewModel>()
    //private lateinit var gridAdapter: MainGridAdapter
    // lateinit var listAdapter: MainListAdapter
    //private lateinit var bannerAdapter: MainViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getItemList()

        viewModel.response.observe(viewLifecycleOwner) {
            //it.forEach(::drawView)
        }
    }

    /*
    private fun drawView(data: SectionItemDto) = with(binding) {
        when (data.viewType) {
            "VIEW_TYPE_CARD" -> {
                listAdapter = MainListAdapter(data.design)
                listAdapter.submitList(data.body)

                val tvTitle = TextView(requireContext())
                val params = ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(
                    toPx(tvTitle.context, data.design?.left ?: 16),
                    toPx(tvTitle.context, data.design?.top ?: 8),
                    0,
                    toPx(tvTitle.context, data.design?.bottom ?: 8)
                )
                tvTitle.layoutParams = params
                tvTitle.text = data.header?.header
                fragmentMain.addView(tvTitle)

                val rvList = RecyclerView(requireContext())
                rvList.adapter = listAdapter
                rvList.layoutManager = LinearLayoutManager(requireContext())
                fragmentMain.addView(rvList)
            }

            "VIEW_TYPE_BANNER" -> {
                bannerAdapter = MainViewPagerAdapter()
                val vpBanner = ViewPager2(requireContext())
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
                fragmentMain.addView(vpBanner)
                bannerAdapter.submitList(data.body)
            }

            "VIEW_TYPE_GRID" -> {
                gridAdapter = MainGridAdapter(data.design)
                gridAdapter.submitList(data.body)

                val tvTitle = TextView(requireContext())
                val params = ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(
                    toPx(tvTitle.context, data.design?.left ?: 16),
                    toPx(tvTitle.context, data.design?.top ?: 8),
                    0,
                    toPx(tvTitle.context, data.design?.bottom ?: 8)
                )
                tvTitle.layoutParams = params
                tvTitle.text = data.header?.header
                fragmentMain.addView(tvTitle)

                val rvGrid = RecyclerView(requireContext())
                rvGrid.layoutManager = GridLayoutManager(requireContext(), data.gridInfo?.col ?: 4)
                rvGrid.adapter = gridAdapter
                fragmentMain.addView(rvGrid)
            }
        }

    }
*/
}