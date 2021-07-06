package com.example.medico.StockageLocal.Entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName ="conseils",foreignKeys =
arrayOf(
    ForeignKey(entity = Doctors::class,
        parentColumns = arrayOf("IdDoc"),
        childColumns = arrayOf("IdDoc"),
        onDelete = ForeignKey.CASCADE)

) )
data class Conseils (

    var IdDoc:Int,
    var IdPatient: Int,
    var obj:String,
    var msg:String,
    var reponse: String,
    var isSynchronized:Int=0
){
    @PrimaryKey(autoGenerate = true)
    var idconseil:Int?=null
}