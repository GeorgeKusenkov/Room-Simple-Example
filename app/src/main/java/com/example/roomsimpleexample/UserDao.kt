package com.example.roomsimpleexample

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
    suspend fun insert(user: NewUser)

    @Delete
    suspend fun delete(user: User)

    @Update
    suspend fun update(user: User)
}