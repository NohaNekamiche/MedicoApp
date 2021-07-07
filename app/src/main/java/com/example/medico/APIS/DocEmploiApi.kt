package com.example.medico.APIS

import com.example.medico.DataClass.DocEmploi
import com.example.medico.DataClass.Heure
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface DocEmploiApi {
    @GET("doctoremploi/getEmploiByIdDoc/{id}")
    fun getEmploiByDoc(@Path("id")id:Int):Call<MutableList<DocEmploi>>
    @DELETE("doctoremploi/deleteEmploiLibre/{id}/{date}/{heure}")
    fun deleteSeance(@Path("id")id:Int,
                     @Path("date")date:String,
                        @Path("heure")heure:String):Call<String>
    @GET("doctoremploi/getTimeByIdDocDate/{id}/{date}")
    fun getTimeByIdDocDate(@Path("id")id:Int,
                           @Path("date")date:String):Call<MutableList<Heure>>

}