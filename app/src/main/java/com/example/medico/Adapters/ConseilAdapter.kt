package com.example.medico.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medico.R

class ConseilAdapter(val context: Context, var data:List<Conseil>): RecyclerView.Adapter<MyConseilHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyConseilHolder {
        return MyConseilHolder(LayoutInflater.from(context).inflate(R.layout.conseil_elt, parent, false))
    }

    override fun getItemCount()=data.size
    override fun onBindViewHolder(holder: MyConseilHolder, position: Int) {
  /*      holder.doc_name.text=data[position].doc
        holder.obj.text=data[position].obj
        holder.heure.text=data[position].heure
        holder.date.text=data[position].date*/
    }

}

class MyConseilHolder(view: View) : RecyclerView.ViewHolder(view) {
    val doc_name= view.findViewById<TextView>(R.id.doc)
    val obj= view.findViewById<TextView>(R.id.obj)
    val heure= view.findViewById<TextView>(R.id.heure)
    val date=view.findViewById<TextView>(R.id.date)



}