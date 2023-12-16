package com.example.task18.network

import com.example.task18.network.model.ResponseModel
import com.example.task18.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET(Constants.END_POINT)
    suspend fun getPersons(@Query("page") page: Int): ResponseModel
}