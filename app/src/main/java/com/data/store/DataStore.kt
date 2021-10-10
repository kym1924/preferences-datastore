package com.data.store

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore("data_store")
val MEMO_KEY = stringPreferencesKey("memo")
