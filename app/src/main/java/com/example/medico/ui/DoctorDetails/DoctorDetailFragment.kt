package com.example.medico.ui.DoctorDetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.medico.R
import com.example.medico.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_rdv_info.*

class DoctorDetailFragment : Fragment() {
    private lateinit var doctorDetailViewModel: DoctorDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        doctorDetailViewModel=ViewModelProvider(this).get(DoctorDetailViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_rdv_info, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val doc=arguments?.getString("docname")
        val adr=arguments?.getString("adr")
        val tel=arguments?.getString("tel")
        doc_name.text=doc
        phone.text=tel
        location.text=adr
        phone.setOnClickListener {
            val uri = Uri.parse("tel:" +tel)
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = uri
            startActivity(dialIntent)
        }
        location.setOnClickListener {

        }
        confirm.setOnClickListener {v->
            //val rdv_info=doc+adr+"1"
            val rdv_info="nohanekamiche"
            val bundle= bundleOf("rdv" to rdv_info)
            v?.findNavController()?.navigate(R.id.nav_to_qrcode,bundle)
        }
    }
}