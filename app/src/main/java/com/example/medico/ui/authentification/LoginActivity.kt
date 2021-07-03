package com.example.medico.ui.authentification

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

import com.example.medico.R
import com.example.medico.Retrofit.RetrofitService
import com.example.medico.dataClass.Auth
import com.example.medico.dataClass.AuthResponse
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        val phone = phone.text.toString()
        val pwd = pwd.text.toString()
        val auth = Auth(phone, pwd)
        login.setOnClickListener {
            val call = RetrofitService.authApi.login(auth)
            call.enqueue(object:Callback<AuthResponse>{
                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                    Log.d("fail login", t.toString())
                    Toast.makeText(this@LoginActivity,"Login fail",Toast.LENGTH_SHORT)
                }

                override fun onResponse(
                    call: Call<AuthResponse>,
                    response: Response<AuthResponse>
                ) {
                   if (response.isSuccessful)
                   {
                       Toast.makeText(this@LoginActivity,"Login success",Toast.LENGTH_SHORT)
                       Log.d("push",response.code().toString())
                       Log.d("push",response.body().toString())
                       Log.d("the token ",response.body().token.toString())

                       val token = response.body()?.token
                       if (token != null) {
                           saveUserToken(token)
                       }

                   }
                }

            })

        }
    }

    private fun saveUserToken(token: String){
        val preferences: SharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE)
        preferences.edit().putString("TOKEN", token).apply()
        /// Retrive Saved TOKEN
        //val retrivedToken = preferences.getString("TOKEN", null) //second parameter default value.
    }




}