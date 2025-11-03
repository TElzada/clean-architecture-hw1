package com.geeks.architecture_hw1.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geeks.architecture_hw1.R
import com.geeks.architecture_hw1.data.api.CountApi
import com.geeks.architecture_hw1.data.repository.CounterRepositoryImpl
import com.geeks.architecture_hw1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val repository = CounterRepositoryImpl(CountApi())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateUI()

        binding.btnIncrement.setOnClickListener {
            repository.increment()
            updateUI("INCREMENT")
        }

        binding.btnDecrement.setOnClickListener {
            repository.decrement()
            updateUI("DECREMENT")
        }

        binding.btnReset.setOnClickListener {
            repository.resetCount()
            updateUI("RESET")
        }
    }

    private fun updateUI(operation: String? = null) {
        val count = repository.getCount()
        binding.tvCount.text = "Count: ${count.count}"
        binding.tvTime.text = "Time: ${count.createdAt}"
        binding.tvOperation.text = "Operation: ${operation ?: count.typeOfOperation}"
    }
}
