package com.laundry.mendadaklaundry.Database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.laundry.mendadaklaundry.Class.Converters

<<<<<<< HEAD:app/src/main/java/com/laundry/mendadaklaundry/Database/OrderApp.kt
@Database(entities = [Order::class, UserEntity::class], version = 2)
abstract class OrderApp: RoomDatabase() {
    abstract fun getOrderDao(): OrderDao
    abstract fun userDao(): UserDao

=======
@Database(entities = [Order::class,RiwayatTb::class,OrderSementara::class], version = 3)
@TypeConverters(Converters::class)
abstract class DatabaseBuilder: RoomDatabase() {
    abstract fun getOrderDao(): OrderDao
    abstract fun getRiwayatDao():RiwayatDao
    abstract fun getOrderSemDao():OrderSemDao
>>>>>>> master:app/src/main/java/com/laundry/mendadaklaundry/Database/DatabaseBuilder.kt
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
<<<<<<< HEAD:app/src/main/java/com/laundry/mendadaklaundry/Database/OrderApp.kt
            OrderApp::class.java,
            name= "data_pesanan"
        ).fallbackToDestructiveMigration().build()
=======
            DatabaseBuilder::class.java,
            name= "db_laundry"
        ).allowMainThreadQueries().build()
>>>>>>> master:app/src/main/java/com/laundry/mendadaklaundry/Database/DatabaseBuilder.kt
    }
}