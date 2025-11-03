package com.geeks.architecture_hw1.data.api

import com.geeks.architecture_hw1.data.models.CountDto

class CountApi {
    private var count = 0

    fun increment(){
        count++
    }

    fun decrement(){
        count--
    }
    fun resetCount(){
        count = 0
    }

    fun getCount(): CountDto {
        return CountDto(
            count= count,
            typeOfOperation = null,
            createdAt = System.currentTimeMillis()
        )

    }
}