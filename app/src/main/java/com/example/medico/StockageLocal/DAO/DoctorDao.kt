package com.example.medico.StockageLocal.DAO

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.medico.StockageLocal.Entity.Doctors

interface DoctorDao {
    @Insert
    fun addDoctor(doctors: Doctors)
    @Delete
    fun deleteDoctor(doctors: Doctors)
    @Update
    fun updateDoctor(doctors: Doctors)
    @Query("select * from doctors")
    fun getAllDoctors():List<Doctors>
}