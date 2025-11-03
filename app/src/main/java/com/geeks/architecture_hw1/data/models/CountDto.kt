package com.geeks.architecture_hw1.data.models

import com.geeks.architecture_hw1.domain.models.TypeOfOperation

data class CountDto (
    val count: Int? = null,
    val typeOfOperation: String? = null,
    val createdAt: Long? = null,


    )
