package com.nicoqueijo.fetchrewards.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicoqueijo.fetchrewards.model.Item
import com.nicoqueijo.fetchrewards.repository.Repository
import com.nicoqueijo.fetchrewards.util.Utils.isNetworkAvailable
import com.nicoqueijo.fetchrewards.util.Utils.showNoInternetToast
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val response: MutableLiveData<Response<List<Item>>> = MutableLiveData()

    fun getItems() {
        if (repository.context.isNetworkAvailable()) {
            viewModelScope.launch {
                response.value = repository.getItems()
            }
        } else {
            repository.context.showNoInternetToast()
        }
    }
}