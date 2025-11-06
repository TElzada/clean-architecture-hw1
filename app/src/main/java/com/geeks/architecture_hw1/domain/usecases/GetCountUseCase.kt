package com.geeks.architecture_hw1.domain.usecases

import com.geeks.architecture_hw1.domain.models.Count
import com.geeks.architecture_hw1.domain.repository.CounterRepository

class GetCountUseCase(
    private val repository: CounterRepository
) {
    fun getCount(): Count{
        return repository.getCount()
    }
}