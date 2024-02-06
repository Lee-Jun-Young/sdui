package com.example.sdui.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdui.data.dto.SectionAppBarDto
import com.example.sdui.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: MainAdapter

    private val viewModel by viewModels<MainViewModel>()

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

        adapter = MainAdapter()
        viewModel.getItemList()

        viewModel.staticData.observe(viewLifecycleOwner) {
            it?.sections?.forEach { data ->
                when (data) {
                    is SectionAppBarDto -> {
                        binding.tvTitle.text = data.body?.title
                    }
                }
            }
        }

        viewModel.dynamicData.observe(viewLifecycleOwner) {
            adapter.submitListEx(it?.sections ?: emptyList())

            binding.rvMain.adapter = adapter
            binding.rvMain.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}