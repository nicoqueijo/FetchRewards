package com.nicoqueijo.fetchrewards.repository

import android.content.Context
import com.nicoqueijo.fetchrewards.api.RetrofitInstance
import com.nicoqueijo.fetchrewards.model.Item
import retrofit2.Response

class Repository(val context: Context) {

    suspend fun getItems(): Response<List<Item>> {
        return RetrofitInstance.apiService.getItems()
    }
}