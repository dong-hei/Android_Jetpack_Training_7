package com.dk.datastore

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val myDataStore = MyDataStore(application)

    fun insert(userName : String) = viewModelScope.launch {
        myDataStore.insertUsername(userName)
    }

    val read = myDataStore.getUserName.asLiveData()
}