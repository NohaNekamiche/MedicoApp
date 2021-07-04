package com.example.medico.ui.onBoarding

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.medico.MainActivity
import com.example.medico.R
import com.example.medico.ui.authentification.LoginActivity
import kotlinx.android.synthetic.main.activity_view_pager.*

class OnBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        supportActionBar?.hide()
        viewPager.adapter=OnBoardingAdapter(supportFragmentManager)

        val preferences: SharedPreferences = getSharedPreferences("LoggedIn", Context.MODE_PRIVATE)
        val loggedIn =  preferences.getBoolean("LoggedIn",false)

        var toMain = Intent(this@OnBoardingActivity, LoginActivity::class.java)
        if(loggedIn) {
            println("loggedin")

            toMain = Intent(this@OnBoardingActivity, MainActivity::class.java)
        }

        toMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        println("!loggedin")

        // startActivity(toMain)
        // finish()
    }

}