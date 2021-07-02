package com.example.medico.ui.rdvs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medico.Adapters.DoctorsAdapter
import com.example.medico.Adapters.RdvAdapter
import com.example.medico.DataClass.Doctor
import com.example.medico.DataClass.Rdv
import com.example.medico.R
import kotlinx.android.synthetic.main.fragment_list_doctors.*
import kotlinx.android.synthetic.main.fragment_rdv.*

class RdvsFragment : Fragment() {

    private lateinit var rdvsViewModel: RdvsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        rdvsViewModel =
                ViewModelProvider(this).get(RdvsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_rdv, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        list_rdv.layoutManager = LinearLayoutManager(requireActivity())
        list_rdv.adapter = RdvAdapter(requireActivity(),loaddata())
    }
    fun loaddata():List<Rdv>{
        val data = mutableListOf<Rdv>()
        data.add(Rdv(1,"20/01/2021","12:30","RDV-Généraliste"))
        data.add(Rdv(1,"03/05/2021","02:30","RDV-Généraliste"))
        data.add(Rdv(1,"20/01/2021","15:30","RDV-Généraliste"))
        data.add(Rdv(1,"25/01/2021","16:30","RDV-Généraliste"))
        data.add(Rdv(1,"30/01/2021","12:30","RDV-Généraliste"))
        data.add(Rdv(1,"20/01/2021","12:30","RDV-Généraliste"))
        data.add(Rdv(1,"03/05/2021","02:30","RDV-Généraliste"))
        data.add(Rdv(1,"20/01/2021","15:30","RDV-Généraliste"))
        data.add(Rdv(1,"25/01/2021","16:30","RDV-Généraliste"))
        data.add(Rdv(1,"30/01/2021","12:30","RDV-Généraliste"))
        data.add(Rdv(1,"20/01/2021","12:30","RDV-Généraliste"))
        data.add(Rdv(1,"03/05/2021","02:30","RDV-Généraliste"))
        data.add(Rdv(1,"20/01/2021","15:30","RDV-Généraliste"))
        data.add(Rdv(1,"25/01/2021","16:30","RDV-Généraliste"))
        data.add(Rdv(1,"30/01/2021","12:30","RDV-Généraliste"))
        data.add(Rdv(1,"20/01/2021","12:30","RDV-Généraliste"))
        data.add(Rdv(1,"03/05/2021","02:30","RDV-Généraliste"))
        data.add(Rdv(1,"20/01/2021","15:30","RDV-Généraliste"))
        data.add(Rdv(1,"25/01/2021","16:30","RDV-Généraliste"))
        data.add(Rdv(1,"30/01/2021","12:30","RDV-Généraliste"))
        return data

    }
}