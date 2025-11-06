package com.geeks.architecture_hw1.domain.usecases

import com.geeks.architecture_hw1.domain.repository.CounterRepository

class DecrementUseCase(
    private val repository: CounterRepository
) {
    fun decrement(){
        repository.decrement()
    }
}