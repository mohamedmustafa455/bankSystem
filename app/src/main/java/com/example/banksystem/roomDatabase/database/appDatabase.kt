package com.example.banksystem.roomDatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.banksystem.roomDatabase.DAO.transferDAO
import com.example.banksystem.roomDatabase.DAO.userDAO
import com.example.banksystem.roomDatabase.DataGnerator
import com.example.banksystem.roomDatabase.entity.TrnsferBalanceTable
import com.example.banksystem.roomDatabase.entity.UserTable
import java.util.concurrent.Executors
import java.util.concurrent.locks.Lock

@Database(entities = [TrnsferBalanceTable::class, UserTable::class], version = 1)
abstract class appDatabase : RoomDatabase() {

    abstract fun userDao(): userDAO
    abstract fun transactionsDao(): transferDAO


    companion object {
        @Volatile
        private var Instance: appDatabase? = null
        private val Lock = Any()//used to prevent any  other thred  enter to thred data base

        operator fun invoke(context: Context) = Instance ?: synchronized(Lock) {
            Instance ?: createDatabase(context).also {
                Instance = it
            }
        }

        fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            appDatabase::class.java,
            "app_db"
        ).addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
//pre-populate data
                Executors.newSingleThreadExecutor().execute {
                    Instance?.let {
                        it.userDao().insert(user = DataGnerator.getdata())
                    }
                }
            }
        }).build()


    }
}


