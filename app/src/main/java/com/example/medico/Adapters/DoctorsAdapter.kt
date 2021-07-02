package com.example.medico.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.medico.DataClass.Doctor
import com.example.medico.R

class DoctorsAdapter(val context: Context, var data:List<Doctor>): RecyclerView.Adapter<MyDocHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDocHolder {
        return MyDocHolder(LayoutInflater.from(context).inflate(R.layout.item_doctor, parent, false))
    }

    override fun getItemCount()=data.size
    override fun onBindViewHolder(holder: MyDocHolder, position: Int) {
        holder.doc_name.text="Dr " +data[position].nom+" "+data[position].prenom
        holder.phone.text=data[position].phone
        holder.lieu.text=data[position].lieu
    }

}

class MyDocHolder(view: View) : RecyclerView.ViewHolder(view) {
    val doc_name= view.findViewById<TextView>(R.id.name)
    val phone= view.findViewById<TextView>(R.id.phone_num)
    val lieu= view.findViewById<TextView>(R.id.lieu)



}