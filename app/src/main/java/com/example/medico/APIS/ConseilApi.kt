package com.example.medico.APIS

import com.example.medico.dataClass.Conseil
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ConseilApi {
    @POST("conseil/addConseil")
    fun sendDemande(@Body conseil: Conseil ): Call<Conseil>
}