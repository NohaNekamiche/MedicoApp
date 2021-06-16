package com.example.medico.ui.treatment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.medico.R
import com.example.medico.dataClass.Treatment

class TreatmentAdapter (val context: Context, var data:List<Treatment>): RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(context).inflate(R.layout.treatment_item, parent, false))
    }
    override fun getItemCount()=data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.nom_trt.text=data[position].maladie
        holder.nom_doc.text=data[position].nom_doc
        holder.duree_trt.text=data[position].dateFinTraitement

        val idCardView=holder.cv
        idCardView.setOnClickListener{
            //afficher detail traitement
        }

    }
}
class   Holder(view: View) : RecyclerView.ViewHolder(view) {
    val cv= view.findViewById<CardView>(R.id.treatment_item)
    val nom_trt= view.findViewById<TextView>(R.id.nom_trt)
    val nom_doc= view.findViewById<TextView>(R.id.nom_doc)
    val duree_trt= view.findViewById<TextView>(R.id.duree_trt)



}