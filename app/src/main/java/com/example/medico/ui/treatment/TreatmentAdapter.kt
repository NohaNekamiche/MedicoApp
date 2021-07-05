package com.example.medico.ui.treatment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.medico.R
import com.example.medico.DataClass.TraitementResponse

class TreatmentAdapter (val context: Context, var data:MutableList<TraitementResponse>): RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(context).inflate(R.layout.treatment_item, parent, false))
    }
    override fun getItemCount()=data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.nom_trt.text=data[position].maladie
        holder.nom_doc.text=data[position].nom_doc
        holder.duree_trt.text=data[position].dateFinTraitement.subSequence(0,10)


        val idCardView=holder.cv
        idCardView.setOnClickListener{
                v->
            val titre = data[position].Titre
            val explication=data[position].explication
            val medicaments= data[position].medicaments
            val date= data[position].date
            val idDoc = data[position].idDoc
            // Glide.with(context).load(baseUrl +data[position].img).into(holder.img)

            Toast.makeText(context,medicaments,Toast.LENGTH_SHORT).show()
            val bundle = bundleOf("titre" to titre,"explication" to explication, "medicaments" to medicaments , "date" to date, "idDoc" to idDoc)
            v.findNavController().navigate(R.id.action_navigation_treatment_to_treatmentDetailFragment,bundle)
        }

    }
}
class   Holder(view: View) : RecyclerView.ViewHolder(view) {
    val cv= view.findViewById<CardView>(R.id.treatment_item)
    val nom_trt= view.findViewById<TextView>(R.id.nom_trt)
    val nom_doc= view.findViewById<TextView>(R.id.nom_doc)
    val duree_trt= view.findViewById<TextView>(R.id.duree_trt)



}