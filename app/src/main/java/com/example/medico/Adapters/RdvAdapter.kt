package com.example.medico.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medico.dataClass.Rdv
import com.example.medico.R

class RdvAdapter (val context: Context, var data:List<Rdv>): RecyclerView.Adapter<MyRdvHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRdvHolder {
        return MyRdvHolder(LayoutInflater.from(context).inflate(R.layout.rdv_elt, parent, false))
    }

    override fun getItemCount()=data.size
    override fun onBindViewHolder(holder: MyRdvHolder, position: Int) {
        holder.heure.text=data[position].date
        holder.date.text=data[position].heure
        holder.obj.text=data[position].obj

    }

}

class MyRdvHolder(view: View) : RecyclerView.ViewHolder(view) {
    val heure= view.findViewById<TextView>(R.id.heure)
    val date= view.findViewById<TextView>(R.id.date)
    val obj= view.findViewById<TextView>(R.id.obj)



}