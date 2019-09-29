package com.example.wfsession1

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/Photos")
    fun getTodos() : Call<List<Todo>>
}