package com.geeks.architecture_hw1.di

import com.geeks.architecture_hw1.presentation.count.CountViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        CountViewModel(
            incrementUseCase = get(),
            decrementUseCase = get(),
            resetCountUseCase = get(),
            getCountUseCase = get()
        )
    }
}
