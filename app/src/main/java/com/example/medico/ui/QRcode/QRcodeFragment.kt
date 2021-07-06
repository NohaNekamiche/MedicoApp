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
            val booking= Rdv(1,idDoc!!,idPatient, date_v.text.toString(),time.text.toString(),"RDV-Dentiste")
            val call= booking?.let { it1 -> RetrofitService.bookingApi.addBooking(it1) }
            if (call != null) {
                call.enqueue(object : Callback<MutableList<BookingReponse>> {
                    override fun onFailure(call: Call<MutableList<BookingReponse>>, t: Throwable) {
                        Toast.makeText(context, "can't get doctors", Toast.LENGTH_LONG).show()
                        Log.d("error", t.toString())
                    }
                    override fun onResponse(
                            call: Call<MutableList<BookingReponse>>,
                            response: Response<MutableList<BookingReponse>>
                    ) {

                    }
                })
            }
        }
    }
}