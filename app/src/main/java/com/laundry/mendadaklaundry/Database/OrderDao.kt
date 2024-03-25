package com.laundry.mendadaklaundry.Database

import androidx.room.*
import com.laundry.mendadaklaundry.Database.Order

@Dao
interface OrderDao {
    @Insert
    suspend fun addOrder(order: Order)

    @Query("SELECT * FROM `Order` ORDER BY id DESC")
    suspend fun getAllOrder(): List<Order>

    @Update
    suspend fun updateOrder(order: Order)

    @Delete
    suspend fun deleteOrder(order: Order)
}