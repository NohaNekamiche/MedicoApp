package com.example.medico.StockageLocal.DAO

import androidx.room.*
import com.example.medico.StockageLocal.Entity.Traitement
import java.util.*
@Dao
interface TraitementDao {
    @Insert
    fun addTreatment(traitement: Traitement)
    @Delete
    fun deleteTreatment(traitement: Traitement)
    @Update
    fun updateTreatment(traitement: Traitement)
    @Query("select * from traitements")
    fun getAllTreatment():List<Traitement>
    // Recuperer la liste des traitement en cours

    @Query("Select * from traitements where :currentDate < dateFinTraitement")
    fun getCurrentTreatment(currentDate: Date):List<Traitement>
    //Récuperer le traitement en cours d'un docteur donné
  //  @androidx.room.Query("    select * from traitements where idTraitement=( select idTraitement from bookings bk join doctors dc on bk.idDoc=dc.idDoc where dc.firstName=:firstName and :currentDate<treatmentEndDate )")
  //  fun getCurrentTreatmentByDoctor(firstName:String,currentDate: Date):Treatment
}