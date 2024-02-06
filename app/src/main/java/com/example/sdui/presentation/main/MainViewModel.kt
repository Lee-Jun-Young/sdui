package com.example.sdui.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdui.data.dto.AreaDto
import com.example.sdui.data.dto.ResponseDataDto
import com.example.sdui.domain.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    private val _staticData = MutableLiveData<AreaDto?>()
    val staticData: LiveData<AreaDto?> = _staticData

    private val _dynamicData = MutableLiveData<AreaDto?>()
    val dynamicData: LiveData<AreaDto?> = _dynamicData

    fun getItemList() {
        viewModelScope.launch {
            repository.getItemList().let {
                _staticData.value = it.staticArea
                _dynamicData.value = it.dynamicArea
            }
        }
    }

}