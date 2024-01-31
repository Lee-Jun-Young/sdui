package com.example.sdui.domain

import com.example.sdui.data.dto.ResponseDataDto
import com.example.sdui.data.dto.SectionBannerDto
import com.example.sdui.data.dto.TypeDataDto

interface ItemRepository {

    suspend fun getItemList(): List<TypeDataDto>
}