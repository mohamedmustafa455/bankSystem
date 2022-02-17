package com.example.banksystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.banksystem.Repo.AppRepo
import com.example.banksystem.roomDatabase.database.appDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}