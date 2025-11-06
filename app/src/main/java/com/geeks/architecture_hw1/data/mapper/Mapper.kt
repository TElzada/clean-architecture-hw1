package com.geeks.architecture_hw1.data.mapper

import com.geeks.architecture_hw1.data.models.CountDto
import com.geeks.architecture_hw1.domain.models.Count
import com.geeks.architecture_hw1.domain.models.TypeOfOperation

fun CountDto.mapToDomain(): Count{
    return Count(
        count= this.count?:0,
        typeOfOperation = TypeOfOperation.toOperation(this.typeOfOperation),
        createdAt = this.createdAt ?:0L
    )
}