package com.example.medico.ui.splash

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.medico.MainActivity
import com.example.medico.R
import com.example.medico.ui.authentification.LoginActivity
import com.example.medico.ui.onBoarding.OnBoardingActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        supportActionBar?.hide()

        val preferences: SharedPreferences = getSharedPreferences("LoggedIn", Context.MODE_PRIVATE)
        val loggedIn =  preferences.getBoolean("LoggedIn",false)

        var toMain = Intent(this@WelcomeActivity, OnBoardingActivity::class.java)
        toMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        if(loggedIn) {
            println("loggedin")

            toMain = Intent(this@WelcomeActivity, MainActivity::class.java)
        }
        println("!loggedin")

       // startActivity(toMain)
        // finish()

        start.setOnClickListener {
            val intent = Intent(this, OnBoardingActivity::class.java)
            startActivity(intent)
        }
        skip.setOnClickListener {

            val preferences: SharedPreferences = getSharedPreferences("LoggedIn", Context.MODE_PRIVATE)
            val loggedIn =  preferences.getBoolean("LoggedIn",false)

            var toMain = Intent(this@WelcomeActivity, LoginActivity::class.java)
            if(loggedIn) {
                toMain = Intent(this@WelcomeActivity, MainActivity::class.java)
            }

            toMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(toMain)
            finish()
        }
    }
}