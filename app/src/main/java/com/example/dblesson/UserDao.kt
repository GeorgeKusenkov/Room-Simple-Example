package com.example.dblesson

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): Flow<List<User>>

    @Insert(entity = User::class)
    fun insert(user: NewUser)

    @Delete
    fun delete(user: User)

    @Update
    fun update(user: User)
}