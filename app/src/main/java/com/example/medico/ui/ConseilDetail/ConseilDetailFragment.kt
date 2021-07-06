package com.example.medico.ui.ConseilDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.medico.DataClass.DocEmploi
import com.example.medico.DataClass.Heure
import com.example.medico.R
import com.example.medico.ui.DoctorDetails.DoctorDetailViewModel
import kotlinx.android.synthetic.main.fragment_conseil_detail.*

class ConseilDetailFragment:Fragment() {
    private lateinit var conseilDetailViewModel: ConseilDetailViewModel

    var hour=""
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        conseilDetailViewModel= ViewModelProvider(this).get(ConseilDetailViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_conseil_detail, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val rep=arguments?.getString("rep")
        val doc=arguments?.getString("doc")
        val obj=arguments?.getString("obj")
        val msg=arguments?.getString("msg")

        doc_name.setText(doc)
        msg_val.setText(msg)
        rep_val.setText(rep)
        obj_val.setText(obj)



    }
}