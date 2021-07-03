package com.example.medico.Retrofit

import com.example.medico.APIs.AuthApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val authApi:AuthApi by lazy {
        Retrofit.Builder().baseUrl(baseUrl).
        addConverterFactory(
            GsonConverterFactory.
        create()).
        build().
        create(AuthApi::class.java)
    }
}