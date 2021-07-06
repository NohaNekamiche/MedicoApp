package com.example.medico.ui.DoctorDetails

import android.app.DatePickerDialog
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
import com.bumptech.glide.Glide
import com.example.medico.DataClass.DocEmploi
import com.example.medico.DataClass.Heure
import com.example.medico.R
import com.example.medico.Retrofit.RetrofitService
import kotlinx.android.synthetic.main.fragment_rdv_info.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class DoctorDetailFragment : Fragment() {
    private lateinit var doctorDetailViewModel: DoctorDetailViewModel
    private  var emploi= mutableListOf<DocEmploi>()
    private var d=""
    private  var t=""
    private var m=""
   private  var data = mutableListOf<Heure>()
    var hour=""
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
        val img=arguments?.getString("img")
        val lat=arguments?.getString("lat")
        val lang=arguments?.getString("lang")
        val id=arguments?.getInt("id")
        doc_name.text=doc
        phone.text=tel
        location.text=adr
        Glide.with(requireActivity()).load(img).into(doc_img)
        //select txt of phone
        phone.setOnClickListener {
            val uri = Uri.parse("tel:" +tel)
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = uri
            startActivity(dialIntent)
        }
        //select icon of phone
        phon_ic.setOnClickListener {
            val uri = Uri.parse("tel:" +tel)
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = uri
            startActivity(dialIntent)
        }
        //select txt of location
        location.setOnClickListener {
            val url= Uri.parse("geo:$lat,$lang")

            val uri = Uri.parse("http://maps.google.com/maps?daddr="+lat+","+lang)
            val intent= Intent(Intent.ACTION_VIEW,uri)

            requireActivity().startActivity(intent)
        }
        //select icon of location
        loc.setOnClickListener {
            val url= Uri.parse("geo:$lat,$lang")

            val uri = Uri.parse("http://maps.google.com/maps?daddr="+lat+","+lang)
            val intent= Intent(Intent.ACTION_VIEW,uri)

            requireActivity().startActivity(intent)
        }

        val cal=Calendar.getInstance()
        val year=cal.get(Calendar.YEAR)
        val month=cal.get(Calendar.MONTH)
        val day=cal.get(Calendar.DAY_OF_MONTH)
        var date_choisi=""
        datepicker.setOnClickListener {

            val dp = DatePickerDialog(requireActivity(), DatePickerDialog.OnDateSetListener { picker, mYear, mMonth, mDay ->
                val m=mMonth+1
                date.setText("" + mDay + "-" + m + "-" + mYear)

                date_choisi = "" + mDay + "-" + mMonth + "-" + mYear
                val call = RetrofitService.emploiApi.getTimeByIdDocDate(id!!, date.text.toString())
                call.enqueue(object : Callback<MutableList<Heure>> {
                    override fun onFailure(call: Call<MutableList<Heure>>, t: Throwable) {
                        Toast.makeText(context, "can't get doctors", Toast.LENGTH_LONG).show()
                        Log.d("error", t.toString())
                    }

                    override fun onResponse(
                            call: Call<MutableList<Heure>>,
                            response: Response<MutableList<Heure>>
                    ) {
                        if (response.isSuccessful) {
                            data = response.body()!!
                            Log.d("empoi1", response.body().toString())
                            Log.d("emploi", response.code().toString())
                            val listheure = mutableListOf<String>()
                            for (h in data) {
                                listheure.add(h.heure)
                            }
                            Log.d("heurelist",listheure.toString())
                            time.adapter =
                                    ArrayAdapter<String>(requireActivity(), android.R.layout.simple_list_item_1, listheure
                                    )
                            time.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                                override fun onNothingSelected(p0: AdapterView<*>?) {
                                    TODO("Not yet implemented")
                                }

                                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                    hour=listheure.get(p2)
                                }
                            }
                        }
                    }

                })
            }, year, month, day)
            dp.show()


            /**
             * set list of items for spinner
             */
            //   val listheure= arrayOf(data)



        }


        confirm.setOnClickListener {v->
            val rdv_info=doc+date_choisi+hour+"1"
            //val rdv_info="nohanekamiche"
            val bundle= bundleOf("rdv" to rdv_info,"doc" to doc,"date" to date.text.toString() , "heure" to hour,
                    "idDoc" to id)
            v?.findNavController()?.navigate(R.id.nav_to_qrcode,bundle)
        }
    }
}