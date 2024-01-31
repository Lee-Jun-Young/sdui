package com.example.sdui.domain

import com.example.sdui.data.dto.TypeDataDto

interface ItemRepository {

    suspend fun getItemList(): List<TypeDataDto>
}