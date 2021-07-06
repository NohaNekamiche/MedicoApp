package com.example.medico.StockageLocal.DAO

import androidx.room.*
import com.example.medico.StockageLocal.Entity.Conseils
@Dao
interface ConseilDao {
    @Insert
    fun addConseil(conseils: Conseils)
    @Delete
    fun deleteConseil(conseils: Conseils)
    @Update
    fun updateConseil(conseils: Conseils)
    @Query("select * from conseils")
    fun getAll():List<Conseils>
    @Query("select * from conseils where isSynchronized=0")
    fun getDemandeToSynchronize():List<Conseils>
}