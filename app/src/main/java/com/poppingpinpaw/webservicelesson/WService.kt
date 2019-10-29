package com.poppingpinpaw.webservicelesson

import retrofit2.Call
import retrofit2.http.GET

interface WService {
    @GET("posts")
    fun getPost(): Call<List<Post>>

    @GET("photos")
    fun getPosts(): Call<List<Post>>
}