package com.example.myapplication.ui.screen.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.example.myapplication.features.database.DatabaseInstance
import com.example.myapplication.features.database.table.UtilsEntity

class CustomViewModel(private val application: Application) : AndroidViewModel(application) {

    private val database: DatabaseInstance =
        Room.databaseBuilder(application.baseContext, DatabaseInstance::class.java, "Database")
            .allowMainThreadQueries()
            .build()

    var counter: Int = database.getUtils().getFirst()?.counter ?: 0
        private set

    fun increaseCounter(name: String): Int {
        val newCounter = ++counter
        val entity = database.getUtils().getFirst() ?: UtilsEntity(counter = newCounter)

        database.getUtils().save(entity.copy(counter = newCounter))
        return newCounter
    }

    fun decreaseCounter(name: String): Int {
        val newCounter = --counter
        val entity = database.getUtils().getFirst() ?: UtilsEntity(counter = newCounter)

        database.getUtils().save(entity.copy(counter = newCounter))
        return newCounter
    }
}