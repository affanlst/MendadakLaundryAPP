package com.laundry.mendadaklaundry.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RiwayatDao {
    @Insert
    suspend fun addOrder(riwayat : RiwayatTb)

    @Query("SELECT * FROM `RiwayatTb` ORDER BY id DESC")
    suspend fun getAllOrder(): List<RiwayatTb>

    @Update
    suspend fun updateOrder(riwayat: RiwayatTb)

    @Delete
    suspend fun deleteOrder(riwayat: RiwayatTb)
}