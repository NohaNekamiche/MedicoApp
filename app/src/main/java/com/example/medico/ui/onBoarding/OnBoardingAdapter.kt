package com.example.medico.ui.onBoarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.medico.ui.onBoarding.screens.FourthScreen
import com.example.medico.ui.onBoarding.screens.SecondScreen
import com.example.medico.ui.onBoarding.screens.ThirdScreen

class OnBoardingAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    private val fragments = listOf(
        SecondScreen(),
        ThirdScreen(),
        FourthScreen()
    )
    override fun getItem(position: Int): Fragment {
        return  fragments[position]
    }

    override fun getCount(): Int {
       return fragments.size
    }
}