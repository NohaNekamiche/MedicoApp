package com.example.medico.APIS

import com.example.medico.dataClass.Conseil
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ConseilApi {
    @POST("conseil/addConseil")
    fun sendDemande(@Body conseil: Conseil ): Call<Conseil>

    @GET("")
    fun getConseilByPatient(@Path("id")id:Int ):Call<MutableList<Conseil>>
}