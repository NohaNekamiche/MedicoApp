package com.example.medico.APIS

import com.example.medico.DataClass.Conseil
import com.example.medico.DataClass.ConseilResponse
import com.example.medico.StockageLocal.Entity.Conseils
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ConseilApi {
    @POST("conseil/addConseil")
    fun sendDemande(@Body conseil: Conseil): Call<Conseil>

    @POST("conseil/addLocal")
    fun sendDemandeLocal(@Body conseils: Conseils): Call<Conseils>

    @GET("conseil/getConseilsByIdPatient/{id}")
    fun getConseilByPatient(@Path("id")id:Int ):Call<MutableList<ConseilResponse>>
}