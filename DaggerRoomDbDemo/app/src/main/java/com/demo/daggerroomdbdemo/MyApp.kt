package com.demo.daggerroomdbdemo

import android.app.Application
import com.demo.daggerroomdbdemo.di.AppComponent
import com.demo.daggerroomdbdemo.di.AppModule
import com.demo.daggerroomdbdemo.di.DaggerAppComponent

class MyApp : Application(){

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }

}