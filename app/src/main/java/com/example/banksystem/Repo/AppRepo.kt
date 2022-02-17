package com.example.banksystem.Repo

import androidx.lifecycle.LiveData
import com.example.banksystem.roomDatabase.DAO.transferDAO
import com.example.banksystem.roomDatabase.DAO.userDAO
import com.example.banksystem.roomDatabase.entity.TrnsferBalanceTable
import com.example.banksystem.roomDatabase.entity.UserTable

//val userDao:
class AppRepo (private val userDao:userDAO?=null,private val trnsactionDao:transferDAO?=null){


    //suspend used to creat background thread

    suspend fun addCustomer(customer:List<UserTable>)=userDao?.insert(customer)
     fun getCustomers()=userDao?.getAllUser()
     fun getAllName()=userDao?.getAllName()


    suspend fun insertTransaction(transaction: TrnsferBalanceTable)=trnsactionDao?.insert(transaction)
     fun getALLTransfer()=trnsactionDao?.getALLTransfer()

    suspend fun getOneUser(Name:String)=userDao?.getOneUser(Name)
    suspend fun updateBalnce(user: UserTable)=userDao?.updateBalance(user)



}