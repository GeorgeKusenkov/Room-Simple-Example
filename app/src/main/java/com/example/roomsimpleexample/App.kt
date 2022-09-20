package com.example.roomsimpleexample

import android.app.Application
import androidx.room.Room

class App: Application() {

    lateinit var db: AppDatabase

    override fun onCreate() {
        super.onCreate()

        db = Room
            .inMemoryDatabaseBuilder(
            this,
            AppDatabase::class.java,
        ).build()
    }
}