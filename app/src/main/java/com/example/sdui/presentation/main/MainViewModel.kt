package com.example.sdui.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdui.data.dto.ApiResult
import com.example.sdui.data.dto.AreaDto
import com.example.sdui.data.dto.ResponseDataDto
import com.example.sdui.domain.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    private val _staticData = MutableStateFlow<AreaDto?>(null)
    val staticData: StateFlow<AreaDto?> = _staticData

    private val _dynamicData = MutableStateFlow<AreaDto?>(null)
    val dynamicData: StateFlow<AreaDto?> = _dynamicData

    fun getItemList() {
        viewModelScope.launch {
            repository.getItemList().collectLatest {
                when (it) {
                    is ApiResult.Success -> {
                        _staticData.value = it.data.staticArea
                        _dynamicData.value = it.data.dynamicArea
                    }

                    is ApiResult.Error -> {
                        Timber.e(it.errorMsg)
                    }
                }
            }
        }
    }

}