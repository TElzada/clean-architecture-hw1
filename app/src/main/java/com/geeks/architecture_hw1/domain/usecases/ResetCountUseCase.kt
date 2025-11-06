package com.geeks.architecture_hw1.domain.usecases

import com.geeks.architecture_hw1.domain.repository.CounterRepository

class ResetCountUseCase(
    private val repository: CounterRepository
) {
    fun resetCount(){
        repository.resetCount()
    }
}