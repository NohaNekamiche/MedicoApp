package com.example.medico.StockageLocal.Entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName ="bookings" ,foreignKeys =
arrayOf(
    ForeignKey(entity = Doctors::class,
        parentColumns = arrayOf("idDoc"),
        childColumns = arrayOf("idDoc"),
        onDelete = ForeignKey.CASCADE)


))
data class Booking(

    var idDoc:Int,
    var idPatient:Int,
    var jour:String,
    var mois:String,
    var heure: Date,
    var titre:String
)
{
    @PrimaryKey(autoGenerate = true)
    var idBooking:Int?=null
}