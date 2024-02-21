package com.example.sdui.data.repository

import com.example.sdui.data.datasource.ItemDataSource
import com.example.sdui.data.dto.ResponseDataDto
import com.example.sdui.domain.ItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(private val itemDataSource: ItemDataSource) :
    ItemRepository {

    override suspend fun getItemList(): Flow<ResponseDataDto> {
        return itemDataSource.getItemList()
    }

}