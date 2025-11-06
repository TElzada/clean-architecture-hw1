package com.geeks.architecture_hw1.presentation.count

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geeks.architecture_hw1.databinding.ActivityCountBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CountActivity : AppCompatActivity() {
    private val binding by lazy { ActivityCountBinding.inflate(layoutInflater) }
    private val viewModel: CountViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupListeners()
        observeViewModel()
    }
    private fun setupListeners() {
        binding.btnIncrement.setOnClickListener { viewModel.increment() }
        binding.btnDecrement.setOnClickListener { viewModel.decrement() }
        binding.btnReset.setOnClickListener { viewModel.resetCount() }
    }
    private fun observeViewModel() {
        viewModel.countData.observe(this) { countData ->
            binding.apply {
                tvCount.text = countData.count.toString()
                tvTime.text = formatMillisToDateTime(countData.createdAt)
                tvOperation.text = countData.typeOfOperation.name
            }
        }
    }
    fun formatMillisToDateTime(milliseconds: Long, pattern: String = "HH:mm:ss"): String {
        val date = Date(milliseconds)
        val formatter = SimpleDateFormat(pattern, Locale.getDefault())
        return formatter.format(date)
    }


}
