package com.example.medico.StockageLocal.DAO

import androidx.room.*
import com.example.medico.StockageLocal.Entity.Booking
@Dao
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