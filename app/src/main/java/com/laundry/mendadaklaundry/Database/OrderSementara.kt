package com.laundry.mendadaklaundry.Database
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity("Order_Sementara")
data class OrderSementara(
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo
    var name: String = "",
    @ColumnInfo
    var phone: String = "",
    @ColumnInfo
    var Jenis: String = "",
    @ColumnInfo
    var paket: String = "",
    @ColumnInfo
    var kategori: String = "",
    @ColumnInfo
    var kuantitas: Int,
    @ColumnInfo
    var biaya: Int
)