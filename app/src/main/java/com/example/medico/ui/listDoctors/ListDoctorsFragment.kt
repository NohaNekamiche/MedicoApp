package com.example.medico.ui.listDoctors

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medico.Adapters.DoctorsAdapter
import com.example.medico.DataClass.Doctor
import com.example.medico.R
import com.example.medico.Retrofit.RetrofitService
import kotlinx.android.synthetic.main.fragment_list_doctors.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        //list_docs.layoutManager = LinearLayoutManager(requireActivity())
          //  list_docs.adapter = DoctorsAdapter(requireActivity(),loadData())
        val spec=arguments?.getString("spec")
        if (spec != null) {

            spec_doc.text=spec
            getDoctorsByspeciality(spec)
        }
    }
/*
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
    }*/

    private  fun getDoctorsByspeciality(spec:String){
        val call=RetrofitService.docBySpecialityApi.getDocListBySpeciality(spec)
        call.enqueue(object :Callback<MutableList<Doctor>>{
            override fun onFailure(call: Call<MutableList<Doctor>>, t: Throwable) {
              Toast.makeText(context,"can't get doctors",Toast.LENGTH_LONG).show()
                Log.d("error",t.toString())
            }

            override fun onResponse(
                call: Call<MutableList<Doctor>>,
                response: Response<MutableList<Doctor>>
            ) {
                if(response.isSuccessful){
                    val data=response.body()
                    Log.d("doc",response.body().toString())
                    Log.d("doc",response.code().toString())
                    list_docs.also {
                        list_docs.layoutManager=LinearLayoutManager(requireContext())
                        list_docs.adapter=list_docs?.let {
                            data?.let { it1 -> DoctorsAdapter(requireActivity(), it1) }
                        }
                    }
                }
            }

        })
    }
}