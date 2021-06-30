package com.example.medico.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.medico.R
import com.example.medico.ui.authentification.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        Handler().postDelayed({

                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)


        }, 3000)
    }


}