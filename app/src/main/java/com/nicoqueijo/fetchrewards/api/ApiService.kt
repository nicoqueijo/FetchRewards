package com.nicoqueijo.fetchrewards.api

import com.nicoqueijo.fetchrewards.model.Item
import com.nicoqueijo.fetchrewards.util.Utils.API_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(API_ENDPOINT)
    suspend fun getItems(): Response<List<Item>>
}