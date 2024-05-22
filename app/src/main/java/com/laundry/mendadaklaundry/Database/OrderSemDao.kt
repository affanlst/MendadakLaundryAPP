package com.laundry.mendadaklaundry.Database

import androidx.room.*
import com.laundry.mendadaklaundry.Database.Order
import com.laundry.mendadaklaundry.Database.OrderSementara

@Dao
interface OrderSemDao {
    @Insert
    fun addOrderSem(orderSem: OrderSementara)

    @Query("SELECT * FROM `Order_Sementara` ORDER BY id DESC")
    fun getAllOrderSem(): List<OrderSementara>

    @Update
    fun updateOrderSem(orderSem: OrderSementara)

    @Delete
    fun deleteOrderSem(orderSem: OrderSementara)
}
