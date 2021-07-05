package com.example.medico.StockageLocal.Entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName ="conseils",foreignKeys =
arrayOf(
    ForeignKey(entity = Doctors::class,
        parentColumns = arrayOf("idDoc"),
        childColumns = arrayOf("idDoc"),
        onDelete = ForeignKey.CASCADE)

) )
data class Conseils (

    var idDoc:Int,
    var idPatient: Int,
    var obg:String,
    var msg:String,
    var reponse: String
){
    @PrimaryKey(autoGenerate = true)
    var idConseil:Int?=null
}