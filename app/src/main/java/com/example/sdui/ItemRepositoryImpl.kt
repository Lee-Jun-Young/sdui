package com.example.sdui

import com.example.sdui.data.HeaderDataDto
import com.example.sdui.data.SectionItemDto
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