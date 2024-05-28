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

    @Query("DELETE FROM `Order_Sementara` WHERE id = :id")
    fun deleteOrderSemById(id: Int)

    @Query("""
        DELETE FROM `Order_Sementara` 
        WHERE 
        (:name IS NULL OR name = :name) AND
        (:phone IS NULL OR phone = :phone) AND
        (:jenis IS NULL OR Jenis = :jenis) AND
        (:paket IS NULL OR paket = :paket) AND
        (:kategori IS NULL OR kategori = :kategori) AND
        (:kuantitas IS NULL OR kuantitas = :kuantitas) AND
        (:biaya IS NULL OR biaya = :biaya)
    """)
    fun deleteOrderSem(
        name: String?,
        phone: String?,
        jenis: String?,
        paket: String?,
        kategori: String?,
        kuantitas: Int?,
        biaya: Int?
    )

}
