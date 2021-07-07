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
import com.bumptech.glide.Glide
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
        val date = arguments?.getString("date")
        val doc = arguments?.getString("doc")
        val tel= arguments?.getString("tel")
        val adr= arguments?.getString("adr")
        val img= arguments?.getString("img")
        val lat= arguments?.getString("lat")
        val lang= arguments?.getString("lang")
        val id=arguments?.getInt("idDoc")

        doc_phone.setOnClickListener {
            val uri = Uri.parse("tel:" +tel)
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = uri
            requireActivity().startActivity(dialIntent)
        }
        doc_name.setText(doc)
        Glide.with(requireActivity()).load(img).into(imageView7)
        doc_phone.setText(tel)
        doc_pos.setText(adr)
        doc_pos.setOnClickListener{ view->
            val url= Uri.parse("geo:$lat,$lang")

            val uri = Uri.parse("http://maps.google.com/maps?daddr="+lat+","+lang)
            val intent= Intent(Intent.ACTION_VIEW,uri)

            requireActivity().startActivity(intent)
        }
        Log.d("titre", titre)
        nom_trt.text=titre
        explicationtxt.text=explication
        datedebuttxt.text=date
        medicamentstxt.text=medicaments
        val name_doc="Noha Nekamiche"
        demande.setOnClickListener { v->
            val bundle= bundleOf("iddoc" to id,"nom" to name_doc )
            v.findNavController().navigate(R.id.nav_to_demande_conseil,bundle)
        }


    }




}