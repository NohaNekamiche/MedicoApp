package com.example.medico.StockageLocal.Entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName ="bookings" ,foreignKeys =
arrayOf(
    ForeignKey(entity = Doctors::class,
        parentColumns = arrayOf("IdDoc"),
        childColumns = arrayOf("IdDoc"),
        onDelete = ForeignKey.CASCADE)


))
data class Booking(

    var IdDoc:Int,
    var IdPatient:Int,
    var jour:String,
    var mois:String,
    var heure: String,
    var titre:String
)
{
    @PrimaryKey(autoGenerate = true)
    var idbooking:Int?=null
}