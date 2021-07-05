package com.example.medico.APIS

import com.example.medico.DataClass.Doctor

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DocApi{
    @GET("doctor/getDoctorsBySpeciality/{spec}")
    fun getDocListBySpeciality(@Path("spec")spec :String) : Call<MutableList<Doctor>>

    @GET("doctor/getDoctorById/{id}")
    fun getDoctorById(@Path("id")id:Int): Call<MutableList<Doctor>>

}