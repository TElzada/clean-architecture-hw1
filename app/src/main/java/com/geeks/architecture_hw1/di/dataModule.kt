package com.geeks.architecture_hw1.di

import com.geeks.architecture_hw1.data.api.CountApi
import com.geeks.architecture_hw1.data.repository.CounterRepositoryImpl
import com.geeks.architecture_hw1.domain.repository.CounterRepository
import org.koin.dsl.module

val dataModule = module {
    single { CountApi() }
    single<CounterRepository> { CounterRepositoryImpl(api = get()) }
}
