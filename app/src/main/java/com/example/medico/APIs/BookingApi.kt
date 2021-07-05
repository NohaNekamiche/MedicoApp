package com.example.medico.APIS

import com.example.medico.dataClass.Rdv
import retrofit2.Call
import retrofit2.http.GET

interface BookingApi {
    @GET("booking/getAllBooking")
    fun getAllBooking(): Call<MutableList<Rdv>>
}