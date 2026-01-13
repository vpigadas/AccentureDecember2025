package com.example.myapplication.ui.screen.storage.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlin.jvm.Throws

@Dao
interface UserDao {

    @Insert
    @Throws(Exception::class)
    fun create(user: UserEntity)

    @Update
    @Throws(Exception::class)
    fun update(user: UserEntity)

//    @Insert(onConflict = REPLACE)
    @Upsert
    fun save(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)

    @Query("SELECT * FROM UserEntity")
    fun readAll() : List<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE id = :id")
    fun readAll(id: Int) : List<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE id = :id LIMIT 1")
    fun read(id: Int) : UserEntity?
}