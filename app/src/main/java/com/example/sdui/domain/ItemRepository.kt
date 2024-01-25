package com.example.sdui.domain

import com.example.sdui.data.dto.SectionItemDto

interface ItemRepository {

    suspend fun getItemList(): List<SectionItemDto>
}