package com.example.myapplication.ui.screen.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.example.myapplication.features.database.DatabaseInstance
import com.example.myapplication.ui.screen.storage.database.UserEntity

class DatabaseViewModel(application: Application) : AndroidViewModel(application) {

    val database: DatabaseInstance =
        Room.databaseBuilder(application.baseContext, DatabaseInstance::class.java, "Database")
            .fallbackToDestructiveMigration(true)
            .allowMainThreadQueries()
            .build()

    fun getLastUser(): UserEntity? = database.getUser().readAll().firstOrNull()
}