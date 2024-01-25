package com.example.sdui.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sdui.data.dto.SectionItemDto
import com.example.sdui.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var gridAdapter: MainGridAdapter
    private lateinit var listAdapter: MainListAdapter

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
        listAdapter = MainListAdapter()
        gridAdapter = MainGridAdapter()

        viewModel.response.observe(viewLifecycleOwner) {
            it.forEach(::drawView)
        }
    }

    private fun drawView(data: SectionItemDto) = with(binding) {
        when (data.viewType) {
            "VIEW_TYPE_CARD" -> {
                listAdapter.submitList(data.body)

                val rvList = RecyclerView(requireContext())
                rvList.adapter = listAdapter
                rvList.layoutManager = LinearLayoutManager(requireContext())
                fragmentMain.addView(rvList)
            }
/*
            "VIEW_TYPE_BANNER" -> {
                val rvList = RecyclerView(requireContext())

                rvList.adapter = listAdapter
                rvList.layoutManager = LinearLayoutManager(requireContext())
                fragmentMain.addView(rvList)
            }
 */
            "VIEW_TYPE_GRID" -> {
                gridAdapter.submitList(data.body)

                val tvTitle = TextView(requireContext())
                tvTitle.text = data.header?.header
                fragmentMain.addView(tvTitle)

                val rvGrid = RecyclerView(requireContext())
                rvGrid.layoutManager = GridLayoutManager(requireContext(), data.gridInfo?.col ?: 4)
                rvGrid.adapter = gridAdapter
                fragmentMain.addView(rvGrid)
            }
        }
    }

}