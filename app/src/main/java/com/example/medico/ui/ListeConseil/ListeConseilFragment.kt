package com.example.medico.ui.ListeConseil

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medico.Adapters.ConseilAdapter
import com.example.medico.Adapters.DoctorsAdapter
import com.example.medico.DataClass.Conseil
import com.example.medico.DataClass.ConseilResponse
import com.example.medico.DataClass.Doctor
import com.example.medico.R
import com.example.medico.Retrofit.RetrofitService
import com.example.medico.ui.listDoctors.ListDoctorsViewModel
import kotlinx.android.synthetic.main.fragment_list_conseil.*
import kotlinx.android.synthetic.main.fragment_list_doctors.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListeConseilFragment:Fragment() {

    private lateinit var listeConseilViewModel: ListeConseilViewModel
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        listeConseilViewModel = ViewModelProvider(requireActivity()).get(ListeConseilViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_list_conseil, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val call=RetrofitService.sendDemande.getConseilByPatient(7)
        call.enqueue(object : Callback<MutableList<ConseilResponse>> {
            override fun onFailure(call: Call<MutableList<ConseilResponse>>, t: Throwable) {
                Toast.makeText(context,"can't get doctors", Toast.LENGTH_LONG).show()
                Log.d("error",t.toString())
            }

            override fun onResponse(
                    call: Call<MutableList<ConseilResponse>>,
                    response: Response<MutableList<ConseilResponse>>) {
                if(response.isSuccessful){
                    val data=response.body()
                    Log.d("doc",response.body().toString())
                    Log.d("doc",response.code().toString())
                    list_conseil.also {
                        list_conseil.layoutManager= LinearLayoutManager(requireContext())
                        list_conseil.adapter=list_conseil?.let {
                            data?.let { it1 -> ConseilAdapter(requireActivity(), it1) }
                        }
                    }
                }
            }

        })
    }
}