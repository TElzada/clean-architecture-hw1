package com.geeks.architecture_hw1.di

import com.geeks.architecture_hw1.domain.usecases.DecrementUseCase
import com.geeks.architecture_hw1.domain.usecases.GetCountUseCase
import com.geeks.architecture_hw1.domain.usecases.IncrementUseCase
import com.geeks.architecture_hw1.domain.usecases.ResetCountUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { IncrementUseCase(repository = get()) }
    factory { DecrementUseCase(repository = get()) }
    factory { ResetCountUseCase(repository = get()) }
    factory { GetCountUseCase(repository = get()) }
}
