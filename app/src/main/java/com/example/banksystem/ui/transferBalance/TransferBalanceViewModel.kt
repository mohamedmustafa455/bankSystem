package com.example.banksystem.ui.transferBalance

import android.app.Application
import androidx.lifecycle.*
import com.example.banksystem.Repo.AppRepo
import com.example.banksystem.roomDatabase.database.appDatabase
import com.example.banksystem.roomDatabase.entity.TrnsferBalanceTable

class TransferBalanceViewModel(app: Application) : AndroidViewModel(app) {
     private var repo: AppRepo

    init {
        val userDaoo = appDatabase.invoke(app).userDao()
        val transDao = appDatabase.invoke(app).transactionsDao()
        repo = AppRepo(userDaoo,transDao)

    }
    fun getdata(): LiveData<List<TrnsferBalanceTable>>? {

        return repo.getALLTransfer()

    }
}

class TransViewModelFactory(private val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TransferBalanceViewModel(app) as T
    }
}