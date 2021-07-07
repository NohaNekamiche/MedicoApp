package com.example.medico.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.medico.DataClass.Rdv
import com.example.medico.DataClass.RdvReponse
import com.example.medico.R

class RdvAdapter (val context: Context, var data:List<RdvReponse>): RecyclerView.Adapter<MyRdvHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRdvHolder {
        return MyRdvHolder(LayoutInflater.from(context).inflate(R.layout.rdv_elt, parent, false))
    }

    override fun getItemCount()=data.size
    override fun onBindViewHolder(holder: MyRdvHolder, position: Int) {
        holder.heure.text=data[position].date
        holder.date.text=data[position].heure
        holder.obj.text=data[position].Titre
        holder.rdv_item.setOnClickListener {v->
            val d=data[position].date
            val t=data[position].heure
            Log.d("datrdv",d)
            Log.d("datrdv",t)
            val doc="Dr " +data[position].name+" "+data[position].username
            val id=data[position].IdPatient
            val bundle= bundleOf("date" to d,"heure" to t,"doc" to doc,"idPatient" to id)

            v?.findNavController()?.navigate(R.id.nav_to_rdv_detail,bundle)
        }

    }

}

class MyRdvHolder(view: View) : RecyclerView.ViewHolder(view) {
    val heure= view.findViewById<TextView>(R.id.heure)
    val date= view.findViewById<TextView>(R.id.date)
    val obj= view.findViewById<TextView>(R.id.obj)
    val rdv_item=view.findViewById<ConstraintLayout>(R.id.rdv_item)



}