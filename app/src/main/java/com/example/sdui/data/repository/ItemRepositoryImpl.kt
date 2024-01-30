package com.example.sdui.data.repository

import android.util.Log
import com.example.sdui.data.datasource.ItemDataSource
import com.example.sdui.data.dto.SectionBannerDto

import com.example.sdui.domain.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(private val itemDataSource: ItemDataSource) :
    ItemRepository {

    override suspend fun getItemList(): SectionBannerDto {
        itemDataSource.getItemList()
        return SectionBannerDto(title = "title", id = null)
    }

}