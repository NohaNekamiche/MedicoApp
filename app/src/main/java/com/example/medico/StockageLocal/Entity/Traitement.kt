package com.example.medico.StockageLocal.Entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName ="traitements",foreignKeys =
arrayOf(
        ForeignKey(entity = Booking::class,
                parentColumns = arrayOf("idBooking"),
                childColumns = arrayOf("idBooking"),
                onDelete = ForeignKey.CASCADE)
)

)
data class Traitement(

        var idBooking:Int,
        var maladie:String,
        var explication:String,
        var medicaments:String,
        var dateFinTraitement: Date
){
        @PrimaryKey(autoGenerate = true)
        var idTraitement:Int?=null
}