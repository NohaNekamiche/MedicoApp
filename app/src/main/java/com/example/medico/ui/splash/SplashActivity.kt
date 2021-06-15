package com.example.medico.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.medico.MainActivity
import com.example.medico.R
import com.example.medico.ui.onBoarding.ViewPagerActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        Handler().postDelayed({
            if (onBoardingFinished()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, ViewPagerActivity::class.java)
                startActivity(intent)
            }
        }, 3000)
    }

    private fun onBoardingFinished(): Boolean {
        val sharedPref =
            this@SplashActivity.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }
}