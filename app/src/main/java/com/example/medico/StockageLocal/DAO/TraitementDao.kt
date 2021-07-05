package com.example.medico.StockageLocal.DAO

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.medico.StockageLocal.Entity.Traitement
import retrofit2.http.Query
import java.util.*

interface TraitementDao {
    @Insert
    fun addTreatment(traitement: Traitement)
    @Delete
    fun deleteTreatment(traitement: Traitement)
    @Update
    fun updateTreatment(traitement: Traitement)
    @androidx.room.Query("select * from traitements")
    fun getAllTreatment():List<Traitement>
    // Recuperer la liste des traitement en cours

    @androidx.room.Query("Select * from traitements where :currentDate<dateFinTraitement")
    fun getCurrentTreatment(currentDate: Date):List<Traitement>
    //Récuperer le traitement en cours d'un docteur donné
  //  @androidx.room.Query("    select * from traitements where idTraitement=( select idTraitement from bookings bk join doctors dc on bk.idDoc=dc.idDoc where dc.firstName=:firstName and :currentDate<treatmentEndDate )")
  //  fun getCurrentTreatmentByDoctor(firstName:String,currentDate: Date):Treatment
}