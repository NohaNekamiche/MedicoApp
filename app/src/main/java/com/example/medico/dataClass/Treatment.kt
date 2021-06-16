package com.example.medico.dataClass

data class Treatment (
            val idTraitement:Int,
            val idBooking:Int,
            val nom_doc:String,
            val maladie:String,
            val explication:String,
            val medicament:String,
            val dateFinTraitement:String
)