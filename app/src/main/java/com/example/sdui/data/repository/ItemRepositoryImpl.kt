package com.example.sdui.data.repository

import com.example.sdui.data.dto.HeaderDataDto
import com.example.sdui.data.dto.SectionItemDto
import com.example.sdui.presentation.ItemType
import com.example.sdui.domain.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor() :
    ItemRepository {

    override suspend fun getItemList(): List<SectionItemDto> {
        val list = mutableListOf<SectionItemDto>()

        repeat(10) {
            list.add(
                SectionItemDto(
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