package com.example.medico.dataClass

data class Treatment (
            val idTraitement:Int,
            val idBooking:Int,
            val nom_doc:String,
            val maladie:String,
            val explication:String,
            val medicaments:String,
            val dateFinTraitement:String
)