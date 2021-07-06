package com.example.medico.StockageLocal.Entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
@Entity(tableName ="users" )
data class Users (

    var name:String,
    var username:String,
    var adr:String,
    var phone:String,
    var pwd: String,
    var role:Int
)
{
    @PrimaryKey(autoGenerate = true)
    var idUser:Int?=null
}