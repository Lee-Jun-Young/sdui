package com.example.sdui.data

import com.example.sdui.ItemRepository
import com.example.sdui.ItemRepositoryImpl
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
    fun provideItemRepository(): ItemRepository =
        ItemRepositoryImpl()
}