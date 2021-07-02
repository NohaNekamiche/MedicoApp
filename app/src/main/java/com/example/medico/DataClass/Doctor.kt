package com.example.medico.DataClass

data class Doctor(
        val specialite:String,
        val idUser:Int,
        val photo: Int,
        val latCabinet:String,
        val langCabinet:String,
        val nom:String,
        val prenom:String,
        val phone:String,
        val lieu:String
)