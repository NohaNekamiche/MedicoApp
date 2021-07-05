package com.example.medico.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medico.dataClass.Reponse
import com.example.medico.R

class ReponseAdapter(val context: Context, var data:List<Reponse>): RecyclerView.Adapter<MyRepHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRepHolder {
        return MyRepHolder(LayoutInflater.from(context).inflate(R.layout.rep_elt, parent, false))
    }

    override fun getItemCount()=data.size
    override fun onBindViewHolder(holder: MyRepHolder, position: Int) {
        holder.obj_.text=data[position].obj
    }
}

class MyRepHolder(view: View) : RecyclerView.ViewHolder(view) {
    val obj_= view.findViewById<TextView>(R.id.obj)




}