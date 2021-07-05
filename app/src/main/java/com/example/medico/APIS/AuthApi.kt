package com.example.medico.APIS

import com.example.medico.DataClass.Auth
import com.example.medico.DataClass.AuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    fun login(@Body auth: Auth): Call<AuthResponse>
}