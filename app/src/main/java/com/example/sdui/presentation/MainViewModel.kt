package com.example.sdui.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdui.ItemRepository
import com.example.sdui.data.SectionItemDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    private val _response = MutableLiveData<List<SectionItemDto>>()
    val response: LiveData<List<SectionItemDto>> = _response

    fun getItemList() {
        viewModelScope.launch {
            _response.value = repository.getItemList()
        }
    }

}