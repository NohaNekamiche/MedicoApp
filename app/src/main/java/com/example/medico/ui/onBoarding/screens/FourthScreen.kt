package com.example.medico.ui.onBoarding.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.medico.MainActivity
import com.example.medico.R
import com.example.medico.ui.authentification.LoginActivity
import kotlinx.android.synthetic.main.activity_view_pager.*
import kotlinx.android.synthetic.main.fragment_fourth_screen.*
import kotlinx.android.synthetic.main.fragment_fourth_screen.view.*


class FourthScreen : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_fourth_screen, container, false)
        view.finish.setOnClickListener {

            val intent = Intent(requireActivity(), LoginActivity::class.java)
            requireActivity().startActivity(intent)
            requireActivity().finish()
            onBoardingFinished()

        }

        return view
    }

    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

            editor.putBoolean("Finished", true)

            editor.apply()

    }
}