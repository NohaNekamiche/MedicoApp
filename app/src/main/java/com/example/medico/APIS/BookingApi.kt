package com.example.medico.APIS

import com.example.medico.DataClass.BookingReponse
import com.example.medico.DataClass.Rdv
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BookingApi {
    @GET("booking/getAllBooking")
    fun getAllBooking(): Call<MutableList<Rdv>>

    @POST("booking/addBooking")
    fun addBooking(@Body rdv: Rdv):Call<MutableList<BookingReponse>>
    @GET("booking/getBookingByIdPatient/{id}")
    fun getBookingByIdPatient(@Path("id")id:Int):Call<MutableList<Rdv>>
}