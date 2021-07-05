package com.example.medico.ui.DemandeConseil

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.medico.DataClass.Conseil
import com.example.medico.R
import com.example.medico.Retrofit.RetrofitService
import kotlinx.android.synthetic.main.fragment_demande_consiel.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DemandeConseilFragment:Fragment() {
    private lateinit var demandeConseilViewModel: DemandeConseilViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        demandeConseilViewModel=ViewModelProvider(this).get(DemandeConseilViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_demande_consiel, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val iddoc=arguments?.getInt("iddoc")
        val name_doc=arguments?.getString("nom")
        doc.setText("Dr $name_doc")
        send.setOnClickListener {
            if(obj.text.isEmpty()){
                Toast.makeText(context,"Verifier que vous avez met un objet pour votre demande",Toast.LENGTH_LONG).show()
            }
            else{
                if (msg.text.isEmpty()){
                    Toast.makeText(context,"Verifier que vous avez met votre message",Toast.LENGTH_LONG).show()
                }
                else{
                    if(iddoc!=null){
                    val conseil=Conseil(0,obj.text.toString(),iddoc,6,msg.text.toString(),"")
                    val call=RetrofitService.sendDemande.sendDemande(conseil)
                    call.enqueue(object: Callback<Conseil> {
                        override fun onFailure(call: Call<Conseil>, t: Throwable) {
                            Log.d("error", t.toString())
                            Toast.makeText(context,"demande fail",Toast.LENGTH_SHORT).show()
                        }

                        override fun onResponse(
                            call: Call<Conseil>,
                            response: Response<Conseil>
                        ) {
                            if (response.isSuccessful)
                            {
                                Toast.makeText(context,"demande send success",Toast.LENGTH_SHORT).show()
                                Log.d("push",response.code().toString())
                                Log.d("push",response.body().toString())
                            }
                        }

                    })

                }
                }
            }

        }


    }
}