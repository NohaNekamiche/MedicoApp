package com.example.medico.StockageLocal.DAO

import androidx.room.*
import com.example.medico.StockageLocal.Entity.Doctors
@Dao
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