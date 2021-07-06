package com.example.medico.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.medico.DataClass.Conseil
import com.example.medico.DataClass.ConseilResponse
import com.example.medico.R

class ConseilAdapter(val context: Context, var data:List<ConseilResponse>): RecyclerView.Adapter<MyConseilHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyConseilHolder {
        return MyConseilHolder(LayoutInflater.from(context).inflate(R.layout.rep_elt, parent, false))
    }

    override fun getItemCount()=data.size
    override fun onBindViewHolder(holder: MyConseilHolder, position: Int) {
  /*      holder.doc_name.text=data[position].doc
        holder.obj.text=data[position].obj
        holder.heure.text=data[position].heure
        holder.date.text=data[position].date*/
        holder.doc_name.text="Dr "+data[position].name+ "  "+data[position].username
        holder.obj.text=data[position].obj
        holder.ouvrir.setOnClickListener {v->
            val doc=holder.doc_name.text.toString()
            val obj_c=data[position].obj
            val msg=data[position].msg
            val reponse=data[position].reponse
            val bundle= bundleOf("doc" to doc,"obj" to obj_c,"msg" to msg,
            "rep" to reponse)
            v?.findNavController()?.navigate(R.id.navigate_to_conseildetail,bundle)

        }

    }

}

class MyConseilHolder(view: View) : RecyclerView.ViewHolder(view) {
    val doc_name= view.findViewById<TextView>(R.id.doc)
    val obj= view.findViewById<TextView>(R.id.obj)
    val heure= view.findViewById<TextView>(R.id.heure)
    val date=view.findViewById<TextView>(R.id.date)
    val ouvrir=view.findViewById<TextView>(R.id.ouvrir)



}