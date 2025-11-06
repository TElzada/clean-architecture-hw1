package com.geeks.architecture_hw1.data.repository

import com.geeks.architecture_hw1.data.api.CountApi
import com.geeks.architecture_hw1.data.mapper.mapToDomain
import com.geeks.architecture_hw1.domain.models.Count
import com.geeks.architecture_hw1.domain.repository.CounterRepository


class CounterRepositoryImpl(
    private val api: CountApi,
): CounterRepository {
    override fun increment() {
        api.increment()
    }
    override fun decrement() {
        api.decrement()
    }
    override fun resetCount() {
        api.resetCount()
    }
    override fun getCount(): Count{
        return api.getCount().mapToDomain()
    }

}