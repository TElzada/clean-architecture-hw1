package com.geeks.architecture_hw1.domain.repository

import com.geeks.architecture_hw1.domain.models.Count

interface CounterRepository {
    fun increment()

    fun decrement()

    fun getCount(): Count

    fun resetCount()
}