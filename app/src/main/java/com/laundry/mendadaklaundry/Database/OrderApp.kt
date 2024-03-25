package com.laundry.mendadaklaundry.Database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.laundry.mendadaklaundry.Database.Order

@Database(entities = [Order::class], version = 1)
abstract class OrderApp: RoomDatabase() {
    abstract fun getOrderDao(): OrderDao

    companion object{
        @Volatile
        private var instance : OrderApp? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            OrderApp::class.java,
            name= "data_pesanan"
        ).build()
    }
}