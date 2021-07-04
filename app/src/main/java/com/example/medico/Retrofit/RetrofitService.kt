package com.example.medico.Retrofit

import com.example.medico.APIS.BookingApi
import com.example.medico.APIS.DocApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    val docBySpecialityApi : DocApi by lazy{
        Retrofit.Builder().baseUrl(BASE_URL).
        addConverterFactory(
                GsonConverterFactory.
                create()).
        build().
        create(DocApi::class.java)
    }
    val bookingApi:BookingApi by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).
        addConverterFactory(
            GsonConverterFactory.
            create()).
        build().
        create(BookingApi::class.java)
    }

}