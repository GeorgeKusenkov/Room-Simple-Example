package com.example.dblesson

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class NewUser (
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int? = null,
    @ColumnInfo(name = "firstName") val firstName: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    @ColumnInfo(name = "age") val age: Int
)