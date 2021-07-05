package com.example.medico.Retrofit



import com.example.medico.APIS.ConseilApi
import com.example.medico.APIS.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    val authApi: AuthApi by lazy {
        Retrofit.Builder().baseUrl(baseUrl).
        addConverterFactory(
            GsonConverterFactory.
        create()).
        build().
        create(AuthApi::class.java)
    }
    val treatmentApi: TreatmentApi by lazy {
        Retrofit.Builder().baseUrl(baseUrl).
        addConverterFactory(
            GsonConverterFactory.
            create()).
        build().
        create(TreatmentApi::class.java)
    }
    val docBySpecialityApi : DocApi by lazy{
        Retrofit.Builder().baseUrl(BASE_URL).
        addConverterFactory(
            GsonConverterFactory.
            create()).
        build().
        create(DocApi::class.java)
    }

    val bookingApi: BookingApi by lazy {


        Retrofit.Builder().baseUrl(BASE_URL).
        addConverterFactory(
            GsonConverterFactory.
            create()).
        build().
        create(BookingApi::class.java)
    }
    val sendDemande: ConseilApi by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).
        addConverterFactory(
            GsonConverterFactory.
            create()).
        build().
        create(ConseilApi::class.java)
    }
    val emploiApi:DocEmploiApi by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).
        addConverterFactory(
            GsonConverterFactory.
            create()).
        build().
        create(DocEmploiApi::class.java)
    }

}