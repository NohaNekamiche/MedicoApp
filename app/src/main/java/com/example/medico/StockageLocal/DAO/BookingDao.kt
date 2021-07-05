package com.example.medico.StockageLocal.DAO

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.medico.StockageLocal.Entity.Booking

interface BookingDao {
    @Insert
    fun addBooking(booking: Booking)
    @Delete
    fun deleteBooking(booking: Booking)
    @Update
    fun updateBooking(booking: Booking)
    @Query("select * from bookings")
    fun getAllBooking():List<Booking>
}