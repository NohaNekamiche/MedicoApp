package com.example.medico.ui.splash

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.medico.MainActivity
import com.example.medico.R
import com.example.medico.ui.authentification.LoginActivity
import com.example.medico.ui.onBoarding.OnBoardingActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(3000)
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    if (firstRun()){


                        val toMain = Intent(this@SplashActivity, WelcomeActivity::class.java)
                        startActivity(toMain)
                        finish()
                    }else {
                        println("!first run")
                        val preferences: SharedPreferences = getSharedPreferences("LoggedIn", Context.MODE_PRIVATE)
                        val loggedIn =  preferences.getBoolean("LoggedIn",false)
                        Log.d("LoggedIn",loggedIn.toString())
                       // val preferences: SharedPreferences = this@SplashActivity.getSharedPreferences("MY_APP", Context.MODE_PRIVATE)
                        val idPatient=preferences.getInt("IDUSER",0)

                        Log.d("idPatient1",idPatient.toString())
                        var toMain = Intent(this@SplashActivity, LoginActivity::class.java)
                        if(loggedIn) toMain = Intent(this@SplashActivity, MainActivity::class.java)

                        startActivity(toMain)
                    }
                }
            }
        }
        thread.start()
    }

    private fun firstRun(): Boolean {
        val prefs = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        return prefs.getBoolean("FirstRun", true)

    }
}