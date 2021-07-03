package com.example.medico.ui.authentification

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.medico.MainActivity

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




        login.setOnClickListener {

            val phone = phone.text.toString()
            val pwd = pwd.text.toString()
            Toast.makeText(applicationContext,"phone : $phone",Toast.LENGTH_SHORT).show()

            val auth = Auth(phone, pwd)
            login(auth)

        }
    }

    private  fun login (auth: Auth)
    {
        val call = RetrofitService.authApi.login(auth)
        call.enqueue(object:Callback<AuthResponse>{
            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("fail login", t.toString())
                Toast.makeText(applicationContext,"Login fail",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<AuthResponse>,
                response: Response<AuthResponse>
            ) {
                if (response.isSuccessful)
                {
                    Toast.makeText(applicationContext,"Login success",Toast.LENGTH_SHORT).show()
                    Log.d("push",response.code().toString())
                    Log.d("push",response.body().toString())
                    Log.d("the token ", response.body()?.token.toString())

                    val token = response.body()?.token
                    if (token != null) {
                        startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                        saveUserToken(token)
                    }

                }
            }

        })
    }

    private fun saveUserToken(token: String){
        val preferences: SharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE)
        preferences.edit().putString("TOKEN", token).apply()
        /// Retrive Saved TOKEN
        //val retrivedToken = preferences.getString("TOKEN", null) //second parameter default value.
    }




}