package com.example.medico.ui.QRcode

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
import com.example.medico.DataClass.BookingReponse
import com.example.medico.DataClass.DocEmploi
import com.example.medico.DataClass.Heure
import com.example.medico.DataClass.Rdv
import com.example.medico.R
import com.example.medico.Retrofit.RetrofitService
import com.example.medico.ui.DoctorDetails.DoctorDetailViewModel
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.android.synthetic.main.fragment_rdv_qrcode.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QRcodeFragment :Fragment(){
    private lateinit var qRcodeViewModel: QRcodeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        qRcodeViewModel= ViewModelProvider(this).get(QRcodeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_rdv_qrcode, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val qr_info=arguments?.getString("rdv")
        val doc=arguments?.getString("doc")
        val date=arguments?.getString("date")
        val heure=arguments?.getString("heure")
        val idDoc=arguments?.getInt("idDoc")
        Log.d("Date11",date.toString())
        Log.d("heure11",heure.toString())
        doc_name.setText(doc)
        date_v.setText(date)
        heure_v.setText(heure)
        if(qr_info!=null){
        val multiFormatWriter = MultiFormatWriter()
        try {
            val bitMatrix: BitMatrix =
                multiFormatWriter.encode(qr_info, BarcodeFormat.QR_CODE, 200,
                    200)
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.createBitmap(bitMatrix)
            img_qrcode.setImageBitmap(bitmap)
        } catch (e: WriterException) {
            e.printStackTrace()
        }
        }

        save.setOnClickListener {
            val preferences: SharedPreferences = requireActivity().getSharedPreferences("MY_APP", Context.MODE_PRIVATE)
            val idPatient=preferences.getInt("IDUSER",0)
            Log.d("idPatient",idPatient.toString())
            val booking= Rdv(0,idDoc!!,7, date!!,heure!!,"RDV-Dentiste")
            val call=RetrofitService.bookingApi.addBooking(booking)
            if (call != null) {
                call.enqueue(object : Callback<BookingReponse> {
                    override fun onFailure(call: Call<BookingReponse>, t: Throwable) {
                        Toast.makeText(context, "can't get doctors", Toast.LENGTH_LONG).show()
                        Log.d("error", t.toString())
                    }
                    override fun onResponse(
                            call: Call<BookingReponse>,
                            response: Response<BookingReponse>
                    ) {
                        Log.d("iddoc",idDoc.toString())
                        Log.d("date",date)
                        Log.d("heure",heure)
                        Toast.makeText(context, date +" h :" +heure, Toast.LENGTH_LONG).show()
                        Toast.makeText(context, "Votre rendez-vous est enregister correctement", Toast.LENGTH_LONG).show()
                        delate(idDoc,date,heure)
                    }
                })
            }
        }
    }


    private fun delate(id:Int,date:String,heure:String){
        val call=RetrofitService.emploiApi.deleteSeance(id,date,heure)
        call.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
             //   Toast.makeText(context, "can't get doctors", Toast.LENGTH_LONG).show()
                Log.d("error", t.toString())
            }
            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                //Toast.makeText(context, "Votre rendez-vous est enregister correctement", Toast.LENGTH_LONG).show()
                Log.d("delate", response.body().toString())
            }
        })

    }
}

