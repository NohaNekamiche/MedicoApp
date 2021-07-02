package com.example.medico.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.medico.R
import kotlinx.android.synthetic.main.fragment_accueil.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_accueil, container, false)

        /*
        dentiste.setOnClickListener {

        }
        babies.setOnClickListener {

        }
        neurologie.setOnClickListener {

        }
        eye.setOnClickListener {

        }
        heart.setOnClickListener {

        }*/
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        generaliste.setOnClickListener {
            it.findNavController().navigate(R.id.nav_to_list_doc)
        }
    }
}