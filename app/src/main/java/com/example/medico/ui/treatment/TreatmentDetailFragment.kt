package com.example.medico.ui.treatment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.medico.R
import kotlinx.android.synthetic.main.fragment_treatment_detail.*


class TreatmentDetailFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        doc_phone.setOnClickListener {
            val uri = Uri.parse("tel:" +doc_phone)
            val intent = Intent(Intent.ACTION_CALL, uri)

            /*  if (intent.resolveActivity(context.packageManager) != null) {
                requireActivity().startActivity(intent)
            }*/
        }

           /* val lat=data[position].lat
            val lang=data[position].lang
         doc_pos.setOnClickListener{ view->
                val url=Uri.parse("geo:$lat,$lang")
                val intent= Intent(Intent.ACTION_VIEW,url)
                context.startActivity(intent)
            }*/

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_treatment_detail, container, false)
    }




}