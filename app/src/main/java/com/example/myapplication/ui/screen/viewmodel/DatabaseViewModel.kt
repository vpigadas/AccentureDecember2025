package com.example.myapplication.ui.screen.viewmodel

import android.app.Application
import android.os.Handler
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.myapplication.features.database.DatabaseInstance
import com.example.myapplication.ui.screen.storage.database.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import kotlin.random.Random

class DatabaseViewModel(application: Application) : AndroidViewModel(application) {

    val database: DatabaseInstance =
        Room.databaseBuilder(application.baseContext, DatabaseInstance::class.java, "Database")
            .fallbackToDestructiveMigration(true)
            .build()

    private val executor = Executors.newSingleThreadExecutor()

    fun getLastUser(): LiveData<List<UserEntity>> = database.getUser().streamReadAll()

    fun saveUser() {
        val user = UserEntity(generateRandomNumber(), "", 100, "", "")

//        viewModelScope.launch(Dispatchers.IO) {
//            database.getUser().save(user)
//        }

        runCatching {
            executor.execute {
                database.getUser().save(user)
            }
        }.onFailure {
            Log.e("DatabaseViewModel", "Error: ${it.message}",it)
        }
    }

    fun generateRandomNumber(): Int = Random.nextInt()
}