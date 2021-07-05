package com.example.medico.ui.DoctorDetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.medico.DataClass.DocEmploi
import com.example.medico.R
import com.example.medico.Retrofit.RetrofitService
import kotlinx.android.synthetic.main.fragment_rdv_info.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DoctorDetailFragment : Fragment() {
    private lateinit var doctorDetailViewModel: DoctorDetailViewModel
    private  var emploi= mutableListOf<DocEmploi>()
    private var d=""
    private  var t=""
    private var m=""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        doctorDetailViewModel=ViewModelProvider(this).get(DoctorDetailViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_rdv_info, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val doc=arguments?.getString("docname")
        val adr=arguments?.getString("adr")
        val tel=arguments?.getString("tel")
        doc_name.text=doc
        phone.text=tel
        location.text=adr
        phone.setOnClickListener {
            val uri = Uri.parse("tel:" +tel)
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = uri
            startActivity(dialIntent)
        }
        location.setOnClickListener {

        }


        val call=RetrofitService.emploiApi.getEmploiByDoc(2)
        call.enqueue(object : Callback<MutableList<DocEmploi>> {
            override fun onFailure(call: Call<MutableList<DocEmploi>>, t: Throwable) {
                Toast.makeText(context,"can't get doctors", Toast.LENGTH_LONG).show()
                Log.d("error",t.toString())
            }

            override fun onResponse(
                call: Call<MutableList<DocEmploi>>,
                response: Response<MutableList<DocEmploi>>
            ) {
                if(response.isSuccessful){
                    val data=response.body()
                    Log.d("empoi",response.body().toString())
                    Log.d("emploi",response.code().toString())

                    emploi= data!!
                    Log.d("emploi",emploi[0].toString())
                    //get month
                    val monthlist=  mutableListOf<String>()
                    var i=0
                    for(l in emploi){
                        monthlist.add(l.moi)
                        Log.d("moi",l.moi)
                    }
                    Log.d("list",monthlist.toString())
                    //spinner of month
                    month.adapter=
                        ArrayAdapter<String>(requireActivity(),android.R.layout.simple_list_item_1,monthlist
                        )
                    month.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
                        override fun onNothingSelected(p0: AdapterView<*>?) {
                            TODO("Not yet implemented")
                        }

                        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                             m= month.get(p2).toString()
                            val jourlist= mutableListOf<String>()
                            for (l in emploi){
                                if(monthlist.get(p2)==l.moi){
                                    jourlist.add(l.jourlibre)
                                }
                            }
                            //jour spinner
                            day.adapter= ArrayAdapter<String>(requireActivity(),android.R.layout.simple_list_item_1,jourlist
                            )
                            day.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
                                override fun onNothingSelected(p0: AdapterView<*>?) {
                                    TODO("Not yet implemented")
                                }
                                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                    d=jourlist.get(p2).toString()
                                    val heurlist= mutableListOf<String>()
                                    for (l in emploi){
                                        if (jourlist.get(p2)==l.jourlibre){
                                            heurlist.add(l.heurelibre)

                                        }
                                    }
                                    //heure spinner
                                    time.adapter== ArrayAdapter<String>(requireActivity(),android.R.layout.simple_list_item_1,heurlist
                                    )
                                    time.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
                                        override fun onNothingSelected(p0: AdapterView<*>?) {
                                            TODO("Not yet implemented")
                                        }
                                        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                        t=heurlist.get(p2).toString()
                                            Log.d("rdv",m+ "  "+d+"  "+t)
                                        }
                                    }

                                }
                            }

                        }


                    }
                }
            }

        }

        )


        confirm.setOnClickListener {v->
            val rdv_info=doc+adr+"1"
            //val rdv_info="nohanekamiche"
            val bundle= bundleOf("rdv" to rdv_info)
            v?.findNavController()?.navigate(R.id.nav_to_qrcode,bundle)
        }
    }
}