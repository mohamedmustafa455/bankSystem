package com.example.banksystem.roomDatabase.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.banksystem.roomDatabase.entity.TrnsferBalanceTable

@Dao
interface transferDAO {

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insert(vararg transferRecored: TrnsferBalanceTable)


    @Query("SELECT * FROM TrnsferBalance")
    fun getALLTransfer(): LiveData<List<TrnsferBalanceTable>>

}