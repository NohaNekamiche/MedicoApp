package com.example.medico.ui.QRCodeScanner

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.medico.R
import com.example.medico.ui.QRcode.QRcodeViewModel
import com.google.zxing.BarcodeFormat
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.fragment_scanner.*
import org.json.JSONException
import org.json.JSONObject
import java.util.jar.Manifest

class QRcodeScannerFragment : AppCompatActivity() {

    internal var txtName: TextView? = null

    internal var txtSiteName: TextView? = null

    internal var btnScan: Button? = null

    internal var qrScanIntegrator: IntentIntegrator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtName = findViewById(R.id.name)
        txtSiteName = findViewById(R.id.site_name)

        btnScan = findViewById(R.id.btnScan)
        btnScan!!.setOnClickListener { performAction() }

        qrScanIntegrator = IntentIntegrator(this)

        val button = findViewById<Button>(R.id.showQRScanner)
        button?.setOnClickListener {
            // Add code to show QR Scanner Code in Fragment.
        }
    }

    private fun performAction() {
        qrScanIntegrator?.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            // If QRCode has no data.
            if (result.contents == null) {
                Toast.makeText(this, "getString(R.string.result_not_found)", Toast.LENGTH_LONG).show()
            } else {
                // If QRCode contains data.
                try {
                    // Converting the data to json format
                    val obj = JSONObject(result.contents)

                    // Show values in UI.
                    txtName?.text = obj.getString("name")
                    txtSiteName?.text = obj.getString("site_name")

                } catch (e: JSONException) {
                    e.printStackTrace()

                    // Data not in the expected format. So, whole object as toast message.
                    Toast.makeText(this, result.contents, Toast.LENGTH_LONG).show()
                }

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
