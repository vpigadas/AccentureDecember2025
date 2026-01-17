package com.example.myapplication.features.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.features.database.dao.UtilsDao
import com.example.myapplication.features.database.table.UtilsEntity
import com.example.myapplication.ui.screen.storage.database.UserDao
import com.example.myapplication.ui.screen.storage.database.UserEntity

@Database(entities = [UtilsEntity::class, UserEntity::class], version = 3)
abstract class DatabaseInstance : RoomDatabase(){

    abstract fun getUtils(): UtilsDao

    abstract fun getUser(): UserDao
}