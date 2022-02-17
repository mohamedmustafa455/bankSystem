package com.example.banksystem.roomDatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName ="TrnsferBalance" )
data class TrnsferBalanceTable(@PrimaryKey(autoGenerate = true) val id:Int,
                               var sender:String,
                               var recever:String,
                               var amount:Int

                               )
