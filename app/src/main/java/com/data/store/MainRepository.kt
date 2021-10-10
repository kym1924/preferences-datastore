package com.data.store

import android.content.Context
import androidx.datastore.preferences.core.edit
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val context: Context
) {
    suspend fun setMemo(memo: String) {
        context.dataStore.edit { settings ->
            settings[MEMO_KEY] = memo
        }
    }
}
