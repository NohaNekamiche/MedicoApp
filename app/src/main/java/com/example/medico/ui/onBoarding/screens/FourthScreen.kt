package com.example.medico.ui.onBoarding.screens

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.medico.MainActivity
import com.example.medico.R
import com.example.medico.ui.authentification.LoginActivity
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
            val preferences = this.activity
                ?.getSharedPreferences("LoggedIn", Context.MODE_PRIVATE)

            val loggedIn = preferences?.getBoolean("LoggedIn",false)

            var toMain = Intent(requireContext(), LoginActivity::class.java)
            if(loggedIn!!) {
                toMain = Intent(requireContext(), MainActivity::class.java)
            }

            toMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(toMain)
            requireActivity().finish()

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