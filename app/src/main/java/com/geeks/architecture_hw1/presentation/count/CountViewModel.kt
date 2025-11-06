package com.geeks.architecture_hw1.presentation.count

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.architecture_hw1.domain.models.Count
import com.geeks.architecture_hw1.domain.usecases.DecrementUseCase
import com.geeks.architecture_hw1.domain.usecases.GetCountUseCase
import com.geeks.architecture_hw1.domain.usecases.IncrementUseCase
import com.geeks.architecture_hw1.domain.usecases.ResetCountUseCase

class CountViewModel(
    private val incrementUseCase: IncrementUseCase,
    private val decrementUseCase: DecrementUseCase,
    private val resetCountUseCase: ResetCountUseCase,
    private val getCountUseCase: GetCountUseCase
): ViewModel() {
    private val _countData= MutableLiveData<Count>()
    val countData: LiveData<Count> = _countData

    fun increment(){
        incrementUseCase.increment()
    }
    fun decrement(){
        decrementUseCase.decrement()
    }
    fun resetCount(){
        resetCountUseCase.resetCount()
    }
    private fun getCount(){
        val response = getCountUseCase.getCount()
        _countData.value = response
    }
}