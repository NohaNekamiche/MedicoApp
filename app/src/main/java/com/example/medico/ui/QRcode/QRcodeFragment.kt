package com.example.medico.ui.QRcode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.medico.R
import com.example.medico.ui.DoctorDetails.DoctorDetailViewModel
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.android.synthetic.main.fragment_rdv_qrcode.*

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
    }
}