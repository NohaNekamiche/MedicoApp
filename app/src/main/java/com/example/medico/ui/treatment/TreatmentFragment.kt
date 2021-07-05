package com.example.medico.ui.treatment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medico.R
import com.example.medico.Retrofit.RetrofitService
import com.example.medico.DataClass.TraitementResponse
import kotlinx.android.synthetic.main.fragment_treatment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.sql.Timestamp


class TreatmentFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_treatment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val preferences: SharedPreferences = requireActivity().getSharedPreferences("MY_APP", Context.MODE_PRIVATE)
        val idPatient=preferences.getInt("IDUSER",0)
        val current=System.currentTimeMillis().let { Timestamp(it) }

        println("id patient"+idPatient)
        val call = RetrofitService.treatmentApi.getTraitementByCurrentDate(idPatient,current)
        call.enqueue(object: Callback<MutableList<TraitementResponse>> {
            override fun onFailure(call: Call<MutableList<TraitementResponse>>, t: Throwable) {
                Toast.makeText(context,"Cant get treatments",Toast.LENGTH_SHORT).show()
                Log.d("get", t.toString())
            }

            override fun onResponse(
                    call: Call<MutableList<TraitementResponse>>,
                    response: Response<MutableList<TraitementResponse>>
            ) {
                if(response.isSuccessful){
                    Toast.makeText(context,"getTreatments success",Toast.LENGTH_SHORT).show()
                    Log.d("get",response.code().toString())
                    Log.d("get",response.body().toString())
                    list_treatment.also {
                        val listTraitement=response.body()
                        list_treatment.layoutManager=LinearLayoutManager(requireContext())
                        list_treatment.adapter=
                                listTraitement?.let { it1 -> TreatmentAdapter(requireContext(), it1) }

                    }

                }

            }

        }

        ) }


}


