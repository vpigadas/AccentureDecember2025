package com.example.myapplication.ui.screen.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.example.myapplication.features.database.DatabaseInstance
import com.example.myapplication.features.database.table.UtilsEntity

class CounterViewModel(application: Application) : AndroidViewModel(application) {

    val database: DatabaseInstance =
        Room.databaseBuilder(application.baseContext, DatabaseInstance::class.java, "Database")
            .fallbackToDestructiveMigration(true)
            .allowMainThreadQueries()
            .build()


    fun increaseCounter(): Int {
        val counterEntity = database.getUtils().getFirst() ?: UtilsEntity(counter = 0)

        val newCounterEntity = counterEntity.copy(counter = counterEntity.counter + 1)
        database.getUtils().save(newCounterEntity)
        return newCounterEntity.counter
    }

    fun decreaseCounter(): Int {
        val counterEntity = database.getUtils().getFirst() ?: UtilsEntity(counter = 0)

        val newCounterEntity = counterEntity.copy(counter = counterEntity.counter - 1)
        database.getUtils().save(newCounterEntity)
        return newCounterEntity.counter
    }
}