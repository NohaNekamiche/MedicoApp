package com.example.medico.StockageLocal.Entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName ="traitements",foreignKeys =
arrayOf(
        ForeignKey(entity = Booking::class,
                parentColumns = arrayOf("idbooking"),
                childColumns = arrayOf("idbooking"),
                onDelete = ForeignKey.CASCADE)
)

)
data class Traitement(

        var idbooking:Int,
        var maladie:String,
        var explication:String,
        var medicaments:String,
        var dateFinTraitement: Date
){
        @PrimaryKey(autoGenerate = true)
        var idtraitement:Int?=null
}