package com.laundry.mendadaklaundry.Database

import androidx.room.*
import com.laundry.mendadaklaundry.Database.Order

@Dao
interface OrderDao {
    @Insert
    fun addOrder(order: Order)

    @Query("SELECT * FROM `Order` ORDER BY id DESC")
    fun getAllOrder(): List<Order>

    @Update
    fun updateOrder(order: Order)

    @Delete
    fun deleteOrder(order: Order)
}
