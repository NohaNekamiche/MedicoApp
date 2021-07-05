package com.example.medico.ui.home

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.medico.R
import com.example.medico.StockageLocal.Entity.Booking
import com.example.medico.StockageLocal.Entity.Doctors
import com.example.medico.StockageLocal.Entity.Traitement
import com.example.medico.StockageLocal.Entity.Users
import com.example.medico.StockageLocal.RoomService
import com.example.medico.ui.authentification.LoginActivity
import kotlinx.android.synthetic.main.fragment_home.*
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

      /*  RoomService.context=this.requireContext()

        val usr=Users("lamia","lamia","lamia","lamia","lamia",1)
        RoomService.appDatabase.getUserDao().addDoctor(usr)
        val doc=Doctors(1,"Dentiste","lol","klklk","jjjj")
        RoomService.appDatabase.getDoctorDao().addDoctor(doc)
        val bk=Booking(1,2,"jeudi","septembre","09:00","covid")
        RoomService.appDatabase.getBookingDao().addBooking(bk)
        val datefin= SimpleDateFormat("dd/MM/yyyy").parse("10/08/2021")
        val tr=Traitement(1,"convid","loool","lol",datefin)
        val datefin2= SimpleDateFormat("dd/MM/yyyy").parse("10/06/2021")
        val tr2=Traitement(1,"conviiiiiiiiiid","loool","lol",datefin2)
        println("datra fin "+datefin)
        RoomService.appDatabase.getTreatmentDao().addTreatment(tr)
        RoomService.appDatabase.getTreatmentDao().addTreatment(tr2)

        button.setOnClickListener { view ->
            val all = RoomService.appDatabase.getTreatmentDao().getAllTreatment()

            val currentdate=System.currentTimeMillis().let { Timestamp(it) }


            println("cuurent"+currentdate)
            val result =RoomService.appDatabase.getTreatmentDao().getCurrentTreatment(currentdate)

            var i =0

            println("siiize"+all.size)
            while (i<result.size)
            {

                Toast.makeText(context, "Voici les traitement en cours ${result[i].maladie}:", Toast.LENGTH_LONG).show()
                i++

            }

        }*/

        button.setOnClickListener {
            val preferences: SharedPreferences = requireActivity().getSharedPreferences("LoggedIn", Context.MODE_PRIVATE)

            preferences.edit().putBoolean("LoggedIn", false).apply()
            var toMain = Intent(requireContext(), LoginActivity::class.java)
            val loggedIn = preferences?.getBoolean("LoggedIn",false)
                if(!loggedIn){
                    requireActivity().startActivity(toMain)
                    requireActivity().finish()

                }else {

                    Toast.makeText(context,"Veuillez réessayer",Toast.LENGTH_SHORT).show()

                }

        }

    }

}