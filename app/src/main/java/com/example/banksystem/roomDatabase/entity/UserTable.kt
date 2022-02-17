package com.example.banksystem.roomDatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
//first step create table
@Entity(tableName = "UserTable")
data class UserTable(@PrimaryKey(autoGenerate = true) val id:Int,
                     var name:String,
                     var email:String,
                     var balence:Int

                     )
