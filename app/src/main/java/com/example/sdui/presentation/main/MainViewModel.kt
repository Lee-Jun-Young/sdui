package com.example.sdui.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdui.data.dto.ResponseDataDto
import com.example.sdui.domain.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    private val _response = MutableLiveData<ResponseDataDto>()
    val response: LiveData<ResponseDataDto> = _response

    fun getItemList() {
        viewModelScope.launch {
            _response.value = repository.getItemList()
        }
    }


}