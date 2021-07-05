package com.example.medico.APIS

import com.example.medico.DataClass.TraitementResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.sql.Timestamp

interface TreatmentApi {
    @GET("traitement/getTraitementByUser/{idPatient}")
    fun getTraitementByUser(@Path("idPatient") idPatient:Int) : Call<MutableList<TraitementResponse>>
    @GET("traitement/getTraitementByCurrentDate/{idPatient}/{current}")
    fun getTraitementByCurrentDate(@Path("idPatient") idPatient:Int,@Path("current") current: Timestamp) : Call<MutableList<TraitementResponse>>
}