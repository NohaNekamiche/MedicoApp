package com.example.medico.APIs

import com.example.medico.dataClass.TraitementResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TreatmentApi {
    @GET("traitement/getTraitementByUser/{idPatient}")
    fun getTraitementByUser(@Path("idPatient") idPatient:Int) : Call<MutableList<TraitementResponse>>
}