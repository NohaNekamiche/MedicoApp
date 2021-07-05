package com.example.medico.StockageLocal

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.medico.StockageLocal.Converter.Converter
import com.example.medico.StockageLocal.DAO.BookingDao
import com.example.medico.StockageLocal.DAO.DoctorDao
import com.example.medico.StockageLocal.DAO.TraitementDao
import com.example.medico.StockageLocal.Entity.Booking
import com.example.medico.StockageLocal.Entity.Doctors
import com.example.medico.StockageLocal.Entity.Traitement
import com.example.medico.StockageLocal.Entity.Users

@Database(entities = arrayOf(Doctors::class, Booking::class,Traitement::class,Users::class),version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDoctorDao(): DoctorDao
    abstract fun getBookingDao(): BookingDao
    abstract fun getTreatmentDao(): TraitementDao
}
