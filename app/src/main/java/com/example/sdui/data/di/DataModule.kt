package com.example.sdui.data.di

import com.example.sdui.data.datasource.ItemDataSource
import com.example.sdui.data.datasource.ItemDataSourceImpl
import com.example.sdui.data.repository.ItemRepositoryImpl
import com.example.sdui.domain.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideItemRepository(itemDataSource: ItemDataSource): ItemRepository =
        ItemRepositoryImpl(itemDataSource)

    @Provides
    @Singleton
    fun provideItemDataSource(): ItemDataSource =
        ItemDataSourceImpl()
}