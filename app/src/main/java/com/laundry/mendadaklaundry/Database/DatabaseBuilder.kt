package com.laundry.mendadaklaundry.Database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.laundry.mendadaklaundry.Class.Converters

@Database(entities = [Order::class,RiwayatTb::class,OrderSementara::class], version = 3)
@TypeConverters(Converters::class)
abstract class DatabaseBuilder: RoomDatabase() {
    abstract fun getOrderDao(): OrderDao
    abstract fun getRiwayatDao():RiwayatDao
    abstract fun getOrderSemDao():OrderSemDao
    companion object{
        @Volatile
        private var instance : DatabaseBuilder? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DatabaseBuilder::class.java,
            name= "db_laundry"
        ).allowMainThreadQueries().build()
    }
}