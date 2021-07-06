package com.example.medico.StockageLocal

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.medico.StockageLocal.Converter.Converter
import com.example.medico.StockageLocal.DAO.*
import com.example.medico.StockageLocal.Entity.*

@Database(entities = arrayOf(Doctors::class, Booking::class,Traitement::class,Users::class,
    Conseils::class),version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getConseilDao(): ConseilDao
    abstract fun getDoctorDao(): DoctorDao
    abstract fun getBookingDao(): BookingDao
    abstract fun getTreatmentDao(): TraitementDao
    abstract fun getUserDao(): UserDao

}
