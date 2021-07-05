package com.example.medico.ui.treatment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
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


        return inflater.inflate(R.layout.fragment_treatment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val titre = arguments?.getString("titre").toString()
        val explication = arguments?.getString("explication").toString()
        val medicaments = arguments?.getString("medicaments").toString()
        val date = arguments?.getString("date")?.subSequence(0,10)
        val idDoc = arguments?.getInt("idDoc")
        val lat= arguments?.getString("lat").toString()
        val lang= arguments?.getString("lang").toString()

        doc_phone.setOnClickListener {
            val uri = Uri.parse("tel:0553322126")
            val intent = Intent(Intent.ACTION_CALL, uri)

            if (context?.packageManager?.let { it1 -> intent.resolveActivity(it1) } != null) {
                requireActivity().startActivity(intent)
            }
        }


        doc_pos.setOnClickListener{ view->
            val url=Uri.parse("geo:36.7598942,3.0120671")
            val intent= Intent(Intent.ACTION_VIEW,url)
            context?.startActivity(intent)
        }
        Log.d("titre", titre)
        nom_trt.text=titre
        explicationtxt.text=explication
        datedebuttxt.text=date
        medicamentstxt.text=medicaments
        val name_doc="Noha Nekamiche"
        demande.setOnClickListener { v->
            val bundle= bundleOf("iddoc" to idDoc,"nom" to name_doc )
            v.findNavController().navigate(R.id.nav_to_demande_conseil,bundle)
        }


    }




}