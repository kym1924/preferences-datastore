package com.data.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.data.store.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getMemo()
        setBtnMemoSaveClickListener()
    }

    private fun getMemo() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                getMemoFlow().collect { memo ->
                    binding.tvMemo.text = memo
                }
            }
        }
    }

    private fun getMemoFlow() = dataStore.data
        .map { preferences ->
            preferences[MEMO_KEY] ?: ""
        }

    private fun setBtnMemoSaveClickListener() {
        binding.btnMemoSave.setOnClickListener {
            mainViewModel.setMemo(binding.etMemo.text.toString())
        }
    }
}
