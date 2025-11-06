package com.geeks.architecture_hw1.domain.usecases

import com.geeks.architecture_hw1.domain.repository.CounterRepository

class IncrementUseCase(
    private val repository: CounterRepository
) {
    fun increment(){
        repository.increment()
    }
}