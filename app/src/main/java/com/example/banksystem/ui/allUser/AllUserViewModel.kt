package com.example.banksystem.ui.allUser

import android.app.Application
import androidx.lifecycle.*
import com.example.banksystem.Repo.AppRepo
import com.example.banksystem.roomDatabase.database.appDatabase
import com.example.banksystem.roomDatabase.entity.UserTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllUserViewModel(application: Application) :AndroidViewModel(application)  {

    private var list= MutableLiveData<List<UserTable>>()
    private  var repo: AppRepo
     var readAllData: LiveData<List<UserTable>>
    //private var readNames:LiveData<List<String>>
    init {
        val userDa=appDatabase.invoke(application).userDao()
        repo=AppRepo(userDa)

        //readNames=repo.getAllName()

       // adduser(getdata().value!!)//used once instale

        readAllData= repo.getCustomers()!!
    }
    fun adduser(user:List<UserTable>){
        viewModelScope.launch (Dispatchers.IO){
            repo.addCustomer(user)
        }
    }

//    fun  getdata(): MutableLiveData<List<UserTable>> {
//        var userarray= mutableListOf<UserTable>()
//        userarray.add(UserTable(1,"Mohamed Sarhan ", "Mohamed.Sarhan@bank.system.com",454))
//        userarray.add(UserTable(2,"Ahmed Mustafa " , "Ahmed.Mustafa@bank.system.com",1452))
//        userarray.add(UserTable(3,"Fathy Fawzy "   , "Fathy.Fawzy@bank.system.com",7644))
//        userarray.add(UserTable(4,"Abdullah Sami " , "Abdullah.Sami@bank.system.com",2254))
//        userarray.add(UserTable(5,"Mohamed Sameh " , "Mohamed.Sameh@bank.system.com",6454))
//        userarray.add(UserTable(6,"Abdallah Ehab " , "Abdallah.Ehab@bank.system.com",8454))
//        userarray.add(UserTable(7,"Ahmed Sami ", "Ahmed.Sami@bank.system.com",9454))
//        userarray.add(UserTable(8,"Hazem Farid ", "Hazem.Farid@bank.system.com",1454))
//        userarray.add(UserTable(9,"Mohamed El sayed ", "Mohamed.Elsayed@bank.system.com",2454))
//        userarray.add(UserTable(10,"Mahmoud Mustafa ", "Mahmoud.Mustafa@bank.system.com",2454))
//
//        list.value = userarray
//        return list
//
//
//    }







}