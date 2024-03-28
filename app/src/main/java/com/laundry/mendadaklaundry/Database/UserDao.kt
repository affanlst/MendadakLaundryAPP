package com.laundry.mendadaklaundry.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun register(userEntity: UserEntity )

    @Query("SELECT * FROM UserEntity WHERE username = :username")
    suspend fun getUserByUsername(username: String): UserEntity?

    @Query("SELECT * FROM UserEntity WHERE username = :username AND password = :password")
    fun login(username: String, password: String): UserEntity?


}