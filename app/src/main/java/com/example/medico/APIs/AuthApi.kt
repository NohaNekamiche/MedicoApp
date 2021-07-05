package com.example.medico.APIs

import com.example.medico.dataClass.Auth
import com.example.medico.dataClass.AuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    fun login(@Body auth: Auth): Call<AuthResponse>
}