package com.example.banksystem.roomDatabase

import androidx.lifecycle.MutableLiveData
import com.example.banksystem.roomDatabase.entity.UserTable

class DataGnerator {
    companion object {
        public fun getdata(): List<UserTable> {

            var userarray = mutableListOf<UserTable>()
            userarray.add(UserTable(1, "Mohamed Sarhan ", "Mohamed.Sarhan@bank.system.com", 454))
            userarray.add(UserTable(2, "Ahmed Mustafa ", "Ahmed.Mustafa@bank.system.com", 1452))
            userarray.add(UserTable(3, "Fathy Fawzy ", "Fathy.Fawzy@bank.system.com", 7644))
            userarray.add(UserTable(4, "Abdullah Sami ", "Abdullah.Sami@bank.system.com", 2254))
            userarray.add(UserTable(5, "Mohamed Sameh ", "Mohamed.Sameh@bank.system.com", 6454))
            userarray.add(UserTable(6, "Abdallah Ehab ", "Abdallah.Ehab@bank.system.com", 8454))
            userarray.add(UserTable(7, "Ahmed Sami ", "Ahmed.Sami@bank.system.com", 9454))
            userarray.add(UserTable(8, "Hazem Farid ", "Hazem.Farid@bank.system.com", 1454))
            userarray.add(
                UserTable(
                    9,
                    "Mohamed El sayed ",
                    "Mohamed.Elsayed@bank.system.com",
                    2454
                )
            )
            userarray.add(
                UserTable(
                    10,
                    "Mahmoud Mustafa ",
                    "Mahmoud.Mustafa@bank.system.com",
                    2454
                )
            )
            return userarray


        }
    }
}