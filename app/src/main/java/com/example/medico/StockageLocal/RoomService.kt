package com.example.medico.StockageLocal

import android.content.Context
import androidx.room.Room

object RoomService {
    lateinit var context: Context
    val appDatabase:AppDatabase by lazy {
        Room.databaseBuilder(context,AppDatabase::class.java,"db19") .allowMainThreadQueries().build()
    }
}