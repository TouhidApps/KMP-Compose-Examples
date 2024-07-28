package com.touhidapps.koin;

import android.app.Application
import di.initKoin
import org.koin.android.ext.koin.androidContext

public class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@MyApp)
        }

    }

}
