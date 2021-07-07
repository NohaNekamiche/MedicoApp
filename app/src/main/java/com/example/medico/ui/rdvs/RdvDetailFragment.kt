package com.example.medico.ui.rdvs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.medico.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.android.synthetic.main.fragment_rdv_qrcode.*

class RdvDetailFragment:Fragment() {
    private lateinit var rdvsViewModel: RdvsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rdvsViewModel =
            ViewModelProvider(this).get(RdvsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_booking_detail, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val doc=arguments?.getString("doc")
        val date=arguments?.getString("date")
        val heure=arguments?.getString("heure")
        val idPatient=arguments?.getInt("idPatient")
        val qr_info=doc+" "+date+" "+heure+" "+idPatient.toString()
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

        doc_name.setText(doc)
        date_v.setText(date)
        heure_v.setText(heure)

    }

}