package com.example.sdui.domain

import com.example.sdui.data.dto.SectionBannerDto

interface ItemRepository {

    suspend fun getItemList(): SectionBannerDto
}