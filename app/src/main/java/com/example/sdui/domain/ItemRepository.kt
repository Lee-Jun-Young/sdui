package com.example.sdui.domain

import com.example.sdui.data.dto.SectionItemDto
import com.example.sdui.data.dto.SectionsDto

interface ItemRepository {

    suspend fun getItemList(): SectionsDto
}