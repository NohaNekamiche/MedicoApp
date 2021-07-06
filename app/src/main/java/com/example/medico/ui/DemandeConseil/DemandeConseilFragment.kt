package com.example.medico.ui.DemandeConseil

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
import androidx.room.Room
import androidx.work.*
import com.example.medico.DataClass.Conseil
import com.example.medico.R
import com.example.medico.Retrofit.RetrofitService
import com.example.medico.StockageLocal.Entity.Conseils
import com.example.medico.StockageLocal.Entity.Doctors
import com.example.medico.StockageLocal.Entity.Users
import com.example.medico.StockageLocal.RoomService
import com.example.medico.StockageLocal.Service.SyncService
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
        RoomService.context=this.requireContext()
        val iddoc=arguments?.getInt("idoc")
        val name_doc=arguments?.getString("nom")
        val preferences: SharedPreferences = requireActivity().getSharedPreferences("MY_APP", Context.MODE_PRIVATE)
        val idPatient=preferences.getInt("IDUSER",0)
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
                        val conseil=Conseil(0,obj.text.toString(),1,idPatient,msg.text.toString(),"")
                        Toast.makeText(context,"Verifier ${obj.text.toString()}",Toast.LENGTH_LONG).show()
                        val objtxt=obj.text.toString()
                        println("teeext "+objtxt)
                        val local = Conseils(1,idPatient,objtxt,msg.text.toString()," ")
                        val usr= Users("lamia","lamia","lamia","lamia","lamia",1)
                        RoomService.appDatabase.getUserDao().addDoctor(usr)
                        val doc= Doctors(1,"Dentiste","lol","klklk","jjjj")
                        RoomService.appDatabase.getDoctorDao().addDoctor(doc)
                        RoomService.appDatabase.getConseilDao().addConseil(local)
                        val getLocal=RoomService.appDatabase.getConseilDao().getAll()
                        Toast.makeText(context,"demandes : ${getLocal.get(0)}",Toast.LENGTH_SHORT).show()
                        scheduleSycn()

                    }
                }
            }

        }


    }
    private fun scheduleSycn() {
        val constraints = Constraints.Builder().
        setRequiredNetworkType(NetworkType.CONNECTED).
            //    setRequiresBatteryNotLow(true).
        build()
        val req= OneTimeWorkRequest.Builder (SyncService::class.java).
        setConstraints(constraints).addTag("id1").
        build()
        val workManager = context?.let { WorkManager.getInstance(it) }
        if (workManager != null) {
            workManager.enqueueUniqueWork("work", ExistingWorkPolicy.REPLACE,req)
        }

    }
}