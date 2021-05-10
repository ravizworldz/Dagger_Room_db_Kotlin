package com.demo.daggerroomdbdemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.demo.daggerroomdbdemo.database.UserDao
import com.demo.daggerroomdbdemo.database.UserEntity
import javax.inject.Inject

class MainActivityViewModel(application: Application): AndroidViewModel(application){

    @Inject
    lateinit var userDao: UserDao

    lateinit var allUserList: MutableLiveData<List<UserEntity>>

    init {
        (application as MyApp).getAppComponent().inject(this)
        allUserList = MutableLiveData()
        getAllRecords()
    }


    fun getRecordsObserver(): MutableLiveData<List<UserEntity>> {
        return allUserList
    }

    fun getAllRecords() {
        val list = userDao.getAllRecordsFromDB()
        allUserList.postValue(list)
    }

    fun insertRecord(userEntity: UserEntity) {
        userDao.insertRecord(userEntity)
        getAllRecords()
    }
}