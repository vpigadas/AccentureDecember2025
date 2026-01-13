package com.example.myapplication.ui.screen.storage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "username") val name: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "job_title") val jobTitle: String,
    @ColumnInfo(name = "email") val email: String
)