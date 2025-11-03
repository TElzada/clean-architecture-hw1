package com.geeks.architecture_hw1.data.repository

import com.geeks.architecture_hw1.data.api.CountApi
import com.geeks.architecture_hw1.domain.models.Count
import com.geeks.architecture_hw1.domain.models.TypeOfOperation
import com.geeks.architecture_hw1.domain.repository.CounterRepository
import java.text.SimpleDateFormat
import java.util.*

class CounterRepositoryImpl(
    private val api: CountApi,
): CounterRepository {
    override fun increment() {
        api.increment()
    }
    override fun decrement() {
        api.decrement()
    }
    override fun getCount(): Count {
        val dto = api.getCount()
        val type = when (dto.typeOfOperation) {
            "INCREMENT" -> TypeOfOperation.INCREMENT
            "DECREMENT" -> TypeOfOperation.DECREMENT
            "RESET" -> TypeOfOperation.RESET
            else -> TypeOfOperation.RESET
        }

        val formattedDate = dto.createdAt?.let {
            val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            sdf.format(Date(it))
        } ?: ""

        return Count(
            count = dto.count ?: 0,
            typeOfOperation = type,
            createdAt = formattedDate
        )
    }

    override fun resetCount() {
        api.resetCount()
    }

}