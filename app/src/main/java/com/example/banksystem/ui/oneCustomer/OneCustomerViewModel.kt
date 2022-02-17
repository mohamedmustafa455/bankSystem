package com.example.banksystem.ui.oneCustomer

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.*
import com.example.banksystem.Repo.AppRepo
import com.example.banksystem.roomDatabase.database.appDatabase
import com.example.banksystem.roomDatabase.entity.TrnsferBalanceTable
import com.example.banksystem.roomDatabase.entity.UserTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OneCustomerViewModel(application: Application) : AndroidViewModel(application) {


    private var repo: AppRepo
    var readAllNames: LiveData<List<String>>

    var nameSender: String = ""//
    var email: String = ""
    var balance: Int = 0
    var Name: String = "";//reciver
    var temp: String = "0"
    var amount: Int = 0 //temp.toInt()//
    var toastChed = MutableLiveData<Boolean>(false)

    //var addtransaction
    init {
         val userDaoo = appDatabase.invoke(application).userDao()
         val transDao = appDatabase.invoke(application).transactionsDao()

        repo = AppRepo(userDaoo,transDao)
        readAllNames = repo.getAllName()!!
    }

    fun Trans(): Boolean {
        toastChed.value = false
        if (amount <= balance) {
            balance = balance - amount
            viewModelScope.launch(Dispatchers.IO) {

                var getSender: UserTable? = repo.getOneUser(nameSender)
                getSender?.balence = balance
                repo.updateBalnce(getSender!!)

                var getResiver: UserTable? = repo.getOneUser(Name)
                getResiver!!.balence += amount
                repo.updateBalnce(getResiver!!)

                repo.insertTransaction(
                    TrnsferBalanceTable(0,
                        sender = nameSender,
                        recever = Name,
                        amount = amount
                    )
                )


//                var insertTransaction: TrnsferBalanceTable=(TrnsferBalanceTable(0,nameSender,Name,amount))
//                var insertTrans: TrnsferBalanceTable=repo.insertTransaction(insertTransaction?)
            }
        } else
            toastChed.value = true

        return toastChed.value!!;
    }


}