package com.example.myapplication.ui.screen.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDbInstance : RoomDatabase() {

    abstract fun getUserDao(): UserDao
}