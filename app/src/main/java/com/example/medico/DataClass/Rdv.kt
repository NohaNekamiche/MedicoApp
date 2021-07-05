package com.example.medico.DataClass


data class Rdv (
    val idbooking:Int,
    val IdDoc:Int,
    val IdPatient:Int,
    val date:String,
    val heure:String,
    val Titre:String
)