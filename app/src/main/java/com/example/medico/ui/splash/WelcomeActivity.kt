package com.example.medico.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.medico.R
import com.example.medico.ui.authentification.LoginActivity
import com.example.medico.ui.onBoarding.OnBoardingActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        supportActionBar?.hide()

        start.setOnClickListener {
            val intent = Intent(this, OnBoardingActivity::class.java)
            startActivity(intent)
        }
        skip.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}