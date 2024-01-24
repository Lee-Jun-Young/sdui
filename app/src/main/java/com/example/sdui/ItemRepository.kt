package com.example.sdui

import com.example.sdui.data.SectionItemDto

interface ItemRepository {

    suspend fun getItemList(): List<SectionItemDto>
}