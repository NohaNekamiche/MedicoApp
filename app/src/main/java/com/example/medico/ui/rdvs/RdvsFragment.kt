package com.example.medico.ui.rdvs

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medico.Adapters.RdvAdapter
import com.example.medico.DataClass.Rdv
import com.example.medico.DataClass.RdvReponse
import com.example.medico.R
import com.example.medico.Retrofit.RetrofitService
import kotlinx.android.synthetic.main.fragment_rdv.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RdvsFragment : Fragment() {

    private lateinit var rdvsViewModel: RdvsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rdvsViewModel =
            ViewModelProvider(this).get(RdvsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_rdv, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //  list_rdv.layoutManager = LinearLayoutManager(requireActivity())
        //list_rdv.adapter = RdvAdapter(requireActivity(),loaddata())
        getRdvs()
    }
    /* fun loaddata():List<Rdv>{
         val data = mutableListOf<Rdv>()
         data.add(Rdv(1,"20/01/2021","12:30","RDV-Généraliste"))
         data.add(Rdv(1,"03/05/2021","02:30","RDV-Généraliste"))
         data.add(Rdv(1,"20/01/2021","15:30","RDV-Généraliste"))
         data.add(Rdv(1,"25/01/2021","16:30","RDV-Généraliste"))
         data.add(Rdv(1,"30/01/2021","12:30","RDV-Généraliste"))
         data.add(Rdv(1,"20/01/2021","12:30","RDV-Généraliste"))
         data.add(Rdv(1,"03/05/2021","02:30","RDV-Généraliste"))
         data.add(Rdv(1,"20/01/2021","15:30","RDV-Généraliste"))
         data.add(Rdv(1,"25/01/2021","16:30","RDV-Généraliste"))
         data.add(Rdv(1,"30/01/2021","12:30","RDV-Généraliste"))
         data.add(Rdv(1,"20/01/2021","12:30","RDV-Généraliste"))
         data.add(Rdv(1,"03/05/2021","02:30","RDV-Généraliste"))
         data.add(Rdv(1,"20/01/2021","15:30","RDV-Généraliste"))
         data.add(Rdv(1,"25/01/2021","16:30","RDV-Généraliste"))
         data.add(Rdv(1,"30/01/2021","12:30","RDV-Généraliste"))
         data.add(Rdv(1,"20/01/2021","12:30","RDV-Généraliste"))
         data.add(Rdv(1,"03/05/2021","02:30","RDV-Généraliste"))
         data.add(Rdv(1,"20/01/2021","15:30","RDV-Généraliste"))
         data.add(Rdv(1,"25/01/2021","16:30","RDV-Généraliste"))
         data.add(Rdv(1,"30/01/2021","12:30","RDV-Généraliste"))
         return data
=======
      //  list_rdv.layoutManager = LinearLayoutManager(requireActivity())
        //list_rdv.adapter = RdvAdapter(requireActivity(),loaddata())
        getRdvs()
    }
   /* fun loaddata():List<Rdv>{
        val data = mutableListOf<Rdv>()
        data.add(Rdv(1,"20/01/2021","12:30","RDV-Généraliste"))
        data.add(Rdv(1,"03/05/2021","02:30","RDV-Généraliste"))
        data.add(Rdv(1,"20/01/2021","15:30","RDV-Généraliste"))
        data.add(Rdv(1,"25/01/2021","16:30","RDV-Généraliste"))
        data.add(Rdv(1,"30/01/2021","12:30","RDV-Généraliste"))
        data.add(Rdv(1,"20/01/2021","12:30","RDV-Généraliste"))
        data.add(Rdv(1,"03/05/2021","02:30","RDV-Généraliste"))
        data.add(Rdv(1,"20/01/2021","15:30","RDV-Généraliste"))
        data.add(Rdv(1,"25/01/2021","16:30","RDV-Généraliste"))
        data.add(Rdv(1,"30/01/2021","12:30","RDV-Généraliste"))
        data.add(Rdv(1,"20/01/2021","12:30","RDV-Généraliste"))
        data.add(Rdv(1,"03/05/2021","02:30","RDV-Généraliste"))
        data.add(Rdv(1,"20/01/2021","15:30","RDV-Généraliste"))
        data.add(Rdv(1,"25/01/2021","16:30","RDV-Généraliste"))
        data.add(Rdv(1,"30/01/2021","12:30","RDV-Généraliste"))
        data.add(Rdv(1,"20/01/2021","12:30","RDV-Généraliste"))
        data.add(Rdv(1,"03/05/2021","02:30","RDV-Généraliste"))
        data.add(Rdv(1,"20/01/2021","15:30","RDV-Généraliste"))
        data.add(Rdv(1,"25/01/2021","16:30","RDV-Généraliste"))
        data.add(Rdv(1,"30/01/2021","12:30","RDV-Généraliste"))
        return data
>>>>>>> d5af88adc5a97b60c7cc62a580cfc7456db3f47c

     }
 */
    private fun getRdvs(){
        val call=RetrofitService.bookingApi.getAllBooking()
        call.enqueue(object : Callback<MutableList<Rdv>> {
            override fun onFailure(call: Call<MutableList<Rdv>>, t: Throwable) {
                Toast.makeText(context,"can't get doctors", Toast.LENGTH_LONG).show()
                Log.d("error",t.toString())
            }

            override fun onResponse(
                call: Call<MutableList<Rdv>>,
                response: Response<MutableList<Rdv>>
            ) {
                if(response.isSuccessful){
                    val data=response.body()
                    Log.d("doc",response.body().toString())
                    Log.d("doc",response.code().toString())
                    list_rdv.also {
                        list_rdv.layoutManager=LinearLayoutManager(requireContext())
                        list_rdv.adapter=list_rdv?.let {
                            data?.let { it1 -> RdvAdapter(requireActivity(), it1) }
                        }
                    }
                }
            }

        })
    }
*/
    private fun getRdvs(){
        val preferences: SharedPreferences = requireActivity().getSharedPreferences("MY_APP", Context.MODE_PRIVATE)
        val idPatient=preferences.getInt("IDUSER",0)
        Log.d("idPatient",idPatient.toString())
        val call=RetrofitService.bookingApi.getBookingByIdPatientIdDoc(idPatient)
        call.enqueue(object : Callback<MutableList<RdvReponse>> {
            override fun onFailure(call: Call<MutableList<RdvReponse>>, t: Throwable) {
                Toast.makeText(context,"can't get doctors", Toast.LENGTH_LONG).show()
                Log.d("error",t.toString())
            }

            override fun onResponse(
                call: Call<MutableList<RdvReponse>>,
                response: Response<MutableList<RdvReponse>>
            ) {
                if(response.isSuccessful){
                    val data=response.body()
                    Log.d("doc",response.body().toString())
                    Log.d("doc",response.code().toString())
                    list_rdv.also {
                        list_rdv.layoutManager=LinearLayoutManager(requireContext())
                        list_rdv.adapter=list_rdv?.let {
                            data?.let { it1 -> RdvAdapter(requireActivity(), it1) }
                        }
                    }
                }
            }

        })
    }
}