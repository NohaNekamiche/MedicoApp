package com.example.medico.Retrofit

import com.example.medico.APIs.AuthApi
import com.example.medico.APIs.TreatmentApi
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
    val treatmentApi:TreatmentApi by lazy {
        Retrofit.Builder().baseUrl(baseUrl).
        addConverterFactory(
            GsonConverterFactory.
            create()).
        build().
        create(TreatmentApi::class.java)
    }
}