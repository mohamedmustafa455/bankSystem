package com.example.banksystem.roomDatabase.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.banksystem.roomDatabase.entity.UserTable
@Dao
interface userDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert( user:List<UserTable>)

    @Query("SELECT * FROM UserTable ")
    fun getAllUser():LiveData<List<UserTable>>

    @Query("SELECT name FROM UserTable")
     fun getAllName():LiveData<List<String>>

     @Query("SELECT * FROM UserTable WHERE name=:uName")
     suspend fun getOneUser(uName:String):UserTable

    @Update
     suspend  fun updateBalance(user:UserTable )
}