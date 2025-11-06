package com.geeks.architecture_hw1

import android.app.Application
import com.geeks.architecture_hw1.di.dataModule
import com.geeks.architecture_hw1.di.domainModule
import com.geeks.architecture_hw1.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CountApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@CountApplication)
            modules(
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}
