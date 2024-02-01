package com.example.sdui.data.repository

import com.example.sdui.data.datasource.ItemDataSource
import com.example.sdui.data.dto.ResponseDataDto
import com.example.sdui.domain.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(private val itemDataSource: ItemDataSource) :
    ItemRepository {

    override suspend fun getItemList(): ResponseDataDto {
        return itemDataSource.getItemList()
    }

}