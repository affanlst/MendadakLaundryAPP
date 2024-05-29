package com.laundry.mendadaklaundry.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.time.LocalDate

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
    @Query("SELECT tanggal FROM RiwayatTb WHERE " +
            "(:name IS NULL OR name = :name) AND " +
            "(:phone IS NULL OR phone = :phone) AND " +
            "(:jenis IS NULL OR Jenis = :jenis) AND " +
            "(:paket IS NULL OR paket = :paket) AND " +
            "(:kategori IS NULL OR kategori = :kategori) AND " +
            "(:kuantitas IS NULL OR kuantitas = :kuantitas) AND " +
            "(:biaya IS NULL OR biaya = :biaya)")
    fun getTanggalByFilter(
        name: String?,
        phone: String?,
        jenis: String?,
        paket: String?,
        kategori: String?,
        kuantitas: Int?,
        biaya: Int?
    ): List<LocalDate>
}