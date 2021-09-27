package com.khaymoev.myapplication

import android.app.Application
import timber.log.Timber

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            //Чтобы Timber выводил логи в Logcat
            Timber.plant(Timber.DebugTree())
        }
    }
}