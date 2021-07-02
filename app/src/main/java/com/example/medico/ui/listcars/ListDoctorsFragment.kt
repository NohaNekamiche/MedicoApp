package com.example.medico.ui.listcars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medico.Adapters.DoctorsAdapter
import com.example.medico.Adapters.MyDocHolder
import com.example.medico.DataClass.Doctor
import com.example.medico.R
import kotlinx.android.synthetic.main.fragment_list_doctors.*

class ListDoctorsFragment : Fragment() {

    private lateinit var listDoctorsViewModel: ListDoctorsViewModel
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        listDoctorsViewModel = ViewModelProvider(requireActivity()).get(ListDoctorsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_list_doctors, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        list_docs.layoutManager = LinearLayoutManager(requireActivity())
            list_docs.adapter = DoctorsAdapter(requireActivity(),loadData())
    }

    fun loadData():List<Doctor>{
        val data = mutableListOf<Doctor>()
        val doctor1=Doctor("Dentiste",1,R.drawable.doc1,"15","36","Nekamiche","Noha",
        "0555557899","alger,Medea")
        val doctor2=Doctor("Dentiste",1,R.drawable.doc3,"15","36","Larbi","Maya",
            "0555557899","alger,Bouira")
        val doctor3=Doctor("Dentiste",1,R.drawable.doc1,"15","36","Kansab","Samah",
            "0555557899","alger,Ghelizan")
        val doctor4=Doctor("Dentiste",1,R.drawable.doc2,"15","36","Nekamiche","Noha",
            "0555557899","alger,Medea")
        val doctor5=Doctor("Dentiste",1,R.drawable.doc3,"15","36","Larbi","Maya",
            "0555557899","alger,Bouira")
        val doctor6=Doctor("Dentiste",1,R.drawable.doc1,"15","36","Kansab","Samah",
            "0555557899","alger,Ghelizan")
        data.add(doctor1)
        data.add(doctor2)
        data.add(doctor3)
        data.add(doctor4)
        data.add(doctor5)
        data.add(doctor6)

        return data
    }
}