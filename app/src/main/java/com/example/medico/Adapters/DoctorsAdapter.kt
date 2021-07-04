package com.example.medico.Adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.medico.dataClass.Doctor
import com.example.medico.R

class DoctorsAdapter(val context: Context, var data:List<Doctor>): RecyclerView.Adapter<MyDocHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDocHolder {
        return MyDocHolder(LayoutInflater.from(context).inflate(R.layout.item_doctor, parent, false))
    }

    override fun getItemCount()=data.size
    override fun onBindViewHolder(holder: MyDocHolder, position: Int) {
        holder.doc_name.text="Dr " +data[position].name+" "+data[position].username
        holder.phone.text=data[position].phone
        holder.lieu.text=data[position].adr
        val lat=data[position].latCabinet
        val lang=data[position].langCabinet
        holder.location.setOnClickListener {
            val url= Uri.parse("geo:$lat,$lang")
            val intent= Intent(Intent.ACTION_VIEW,url)
            context.startActivity(intent)
        }
        holder.item.setOnClickListener { v->
            val doc=data[position].name+data[position].username
            val adr=data[position].adr
            val bundle= bundleOf("docname" to doc,"adress" to adr)
            v?.findNavController()?.navigate(R.id.nav_to_docdetail,bundle)
        }



    }

}

class MyDocHolder(view: View) : RecyclerView.ViewHolder(view) {
    val doc_name= view.findViewById<TextView>(R.id.name)
    val phone= view.findViewById<TextView>(R.id.phone_num)
    val lieu= view.findViewById<TextView>(R.id.lieu)
    val location=view.findViewById<ImageView>(R.id.location)
    val item=view .findViewById<CardView>(R.id.item_doc)




}