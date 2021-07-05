package com.example.medico.StockageLocal.DAO

import androidx.room.*
import com.example.medico.StockageLocal.Entity.Doctors
import com.example.medico.StockageLocal.Entity.Users

@Dao
interface UserDao {
    @Insert
    fun addDoctor(users: Users)
    @Delete
    fun deleteDoctor(users: Users)
    @Update
    fun updateDoctor(users: Users)
    @Query("select * from users")
    fun getAllDoctors():List<Users>
}