package com.example.medico.ui.onBoarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.medico.R
import com.example.medico.ui.onBoarding.screens.FirstScreen
import com.example.medico.ui.onBoarding.screens.FourthScreen
import com.example.medico.ui.onBoarding.screens.SecondScreen
import com.example.medico.ui.onBoarding.screens.ThirdScreen
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        supportActionBar?.hide()

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen(),
            FourthScreen()
        )
        val adapter = ViewPagerAdapter(
            fragmentList,
            this.supportFragmentManager,
            lifecycle
        )
        viewPager.adapter=adapter
    }
}