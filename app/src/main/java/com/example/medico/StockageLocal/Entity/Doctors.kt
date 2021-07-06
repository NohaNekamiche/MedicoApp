package com.example.medico.StockageLocal.Entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName ="doctors" ,foreignKeys =
arrayOf(
    ForeignKey(entity = Users::class,
        parentColumns = arrayOf("idUser"),
        childColumns = arrayOf("IdUser"),
        onDelete = ForeignKey.CASCADE)

))
data class Doctors (

    var IdUser:Int,
    var specialite:String,
    var photo:String,
    var latCabinet:String,
    var langCabinet:String

){
    @PrimaryKey(autoGenerate = true)
    var IdDoc:Int?=null
}