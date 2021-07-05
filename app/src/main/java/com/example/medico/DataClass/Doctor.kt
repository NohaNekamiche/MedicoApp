package com.example.medico.DataClass


data class Doctor(
        val IdDoc:Int,
        val specialite:String,
        val idUser:Int,
        val photo: String,
        val latCabinet:String,
        val langCabinet:String,
        val name:String,
        val username:String,
        val phone:String,
        val adr:String,
        val Role:String,
        val pwd:String)