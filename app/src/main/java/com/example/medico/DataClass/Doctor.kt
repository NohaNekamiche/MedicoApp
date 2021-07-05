package com.example.medico.dataClass

data class Doctor(
        val idDoc:Int,
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
        val pwd:String
)