package com.example.medico.ui.onBoarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.medico.R
import kotlinx.android.synthetic.main.activity_view_pager.*

class OnBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        supportActionBar?.hide()

        viewPager.adapter=OnBoardingAdapter(supportFragmentManager)
    }
}