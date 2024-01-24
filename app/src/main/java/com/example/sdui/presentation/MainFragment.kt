package com.example.sdui.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sdui.ItemType
import com.example.sdui.data.HeaderDataDto
import com.example.sdui.data.SectionItemListDto
import com.example.sdui.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: MainAdapter

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

        adapter.submitList(setDataClass())

        binding.rvList.adapter = adapter
    }

    private fun setDataClass(): MutableList<SectionItemListDto> {
        val list = mutableListOf<SectionItemListDto>()

        repeat(10) {
            list.add(
                SectionItemListDto(
                    viewType = ItemType.CARD_TYPE.name,
                    header = HeaderDataDto(
                        header = it.toString(),
                    )
                )
            )
        }
        return list
    }
}