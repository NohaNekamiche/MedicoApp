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
import com.bumptech.glide.Glide
import com.example.medico.DataClass.Doctor
import com.example.medico.R
import com.example.medico.Retrofit.BASE_URL
import com.google.android.material.imageview.ShapeableImageView


class DoctorsAdapter(val context: Context, var data:List<Doctor>): RecyclerView.Adapter<MyDocHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDocHolder {
        return MyDocHolder(LayoutInflater.from(context).inflate(R.layout.item_doctor, parent, false))
    }

    override fun getItemCount()=data.size
    override fun onBindViewHolder(holder: MyDocHolder, position: Int) {
        val img_url=BASE_URL+data[position].photo
        Glide.with(context).load(img_url).into(holder.img)
        holder.doc_name.text="Dr " +data[position].name+" "+data[position].username
        holder.phone.text=data[position].phone
        holder.lieu.text=data[position].adr
        val lat=data[position].latCabinet
        val lang=data[position].langCabinet
        holder.location.setOnClickListener {
            val url= Uri.parse("geo:$lat,$lang")

            val uri = Uri.parse("http://maps.google.com/maps?daddr="+lat+","+lang)
            val intent= Intent(Intent.ACTION_VIEW,uri)

            context.startActivity(intent)
        }
        holder.item.setOnClickListener { v->
            val doc="Dr "+data[position].name+" "+data[position].username
            val adr=data[position].adr
            val tel=data[position].phone
            val id=data[position].IdDoc
            val bundle= bundleOf("id" to id,"docname" to doc,"adr" to adr,"tel" to tel, "img" to img_url,"lat" to lat ,"lang" to lang)

            v?.findNavController()?.navigate(R.id.nav_to_docdetail,bundle)
        }
        holder.phone_txt.setOnClickListener {
            val uri = Uri.parse("tel:" +data[position].phone)
            val dialIntent = Intent(Intent.ACTION_DIAL)

            dialIntent.data = uri
            context.startActivity(dialIntent)
        }
        holder.phone_img.setOnClickListener {
            val uri = Uri.parse("tel:" +data[position].phone)
            val dialIntent = Intent(Intent.ACTION_DIAL)

            dialIntent.data = uri
            context.startActivity(dialIntent)
        }



    }

}

class MyDocHolder(view: View) : RecyclerView.ViewHolder(view) {
    val doc_name= view.findViewById<TextView>(R.id.name)
    val phone= view.findViewById<TextView>(R.id.phone_num)
    val lieu= view.findViewById<TextView>(R.id.lieu)
    val location=view.findViewById<ImageView>(R.id.location)
    val item=view .findViewById<CardView>(R.id.item_doc)
    val  phone_txt=view.findViewById<TextView>(R.id.phone_num)
    val phone_img=view.findViewById<ImageView>(R.id.phone)
    val img=view.findViewById<ShapeableImageView>(R.id.img)




}