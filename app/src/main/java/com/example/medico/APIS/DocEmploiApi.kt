package com.example.medico.APIS

import com.example.medico.DataClass.DocEmploi
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface DocEmploiApi {
    @GET("doctoremploi/getEmploiByIdDoc/{id}")
    fun getEmploiByDoc(@Path("id")id:Int):Call<MutableList<DocEmploi>>
    @DELETE("doctoremploi/deleteEmploiLibre")
    fun deleteSeance(@Body docEmploi: DocEmploi):Call<String>

}