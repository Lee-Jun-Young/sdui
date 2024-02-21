package com.example.sdui.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdui.data.dto.SectionAppBarDto
import com.example.sdui.databinding.FragmentMainBinding
import com.example.sdui.presentation.main.adapter.MainAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.staticData.collect {
                        it?.sections?.forEach { data ->
                            when (data) {
                                is SectionAppBarDto -> {
                                    binding.tvTitle.text = data.title
                                }
                            }
                        }
                    }
                }
                launch {
                    viewModel.dynamicData.collect {
                        adapter.submitListEx(it?.sections ?: emptyList())

                        binding.rvMain.adapter = adapter
                        binding.rvMain.layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
        }

    }
}