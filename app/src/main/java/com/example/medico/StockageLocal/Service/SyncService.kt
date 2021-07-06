package com.example.medico.StockageLocal.Service

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import androidx.work.impl.utils.futures.SettableFuture
import com.example.medico.DataClass.Conseil
import com.example.medico.Retrofit.RetrofitService
import com.example.medico.StockageLocal.Entity.Conseils
import com.example.medico.StockageLocal.RoomService
import com.google.common.util.concurrent.ListenableFuture
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("RestrictedApi")
class SyncService(val ctx: Context, val workParamters: WorkerParameters):
    ListenableWorker(ctx, workParamters){

    lateinit var  future: SettableFuture<Result>



    override fun startWork(): ListenableFuture<Result> {

        future = SettableFuture.create()
        val demandes = RoomService.appDatabase.getConseilDao().getDemandeToSynchronize()
        var i=0
        println("sizeee "+demandes.size)
        while (i<demandes.size)
        {
            addDemande(demandes.get(i))
                i++
        }
        return future
    }


    fun addDemande(conseils: Conseils) {
        val result = RetrofitService.sendDemande.sendDemandeLocal(conseils)
        result.enqueue(object: Callback<Conseils> {
            override fun onFailure(call: Call<Conseils>, t: Throwable) {
                future.set(Result.retry())
            }

            override fun onResponse(call: Call<Conseils>, response: Response<Conseils>) {
                if(response?.isSuccessful!!) {

                    conseils.isSynchronized = 1

                    RoomService.appDatabase.getConseilDao().updateConseil(conseils)

                    future.set(Result.success())
                    Log.d("push",response.body().toString())
                    Log.d("push",response.code().toString())

                }
                else
                {
                    future.set(Result.retry())
                    Log.d("push",response.body().toString())
                    Log.d("push",response.code().toString())

                }
            }


        })
    }


}
