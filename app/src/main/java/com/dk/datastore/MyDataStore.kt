package com.dk.datastore

import android.content.Context
import android.preference.Preference
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MyDataStore(context: Context) {

    private val Context.dataStore : DataStore<Preferences> by preferencesDataStore("user_pref")
    private val mDataStore: DataStore<Preferences> = context.dataStore

    private val USER_NAME_KEY = stringPreferencesKey("USER_NAME")

    suspend fun insertUsername(userName: String) {
        mDataStore.edit { setttings -> setttings[USER_NAME_KEY] = userName }
    }

    val getUserName : Flow<String> = mDataStore.data.map {
        val userName = it[USER_NAME_KEY] ?: "default"
        userName
    }
}