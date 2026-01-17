package com.example.myapplication.features.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.myapplication.features.database.table.UtilsEntity

@Dao
interface UtilsDao {

    @Upsert
    fun save(UtilsEntity: UtilsEntity)

    @Delete
    fun delete(UtilsEntity: UtilsEntity)

    @Query("SELECT * FROM UtilsEntity LIMIT 1")
    fun getFirst(): UtilsEntity?

    @Query("SELECT * FROM UtilsEntity")
    fun getAll(): List<UtilsEntity>
}