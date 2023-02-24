package com.example.weighttracker

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WeightItem::class], version = 1, exportSchema = false)
abstract class WeightItemDatabase : RoomDatabase() {
    abstract fun weightItemDao(): WeightItemDao

    companion object {
        @Volatile
        private var INSTANCE: WeightItemDatabase? = null

        fun getDatabase(context: Context): WeightItemDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WeightItemDatabase::class.java,
                    "weight_item_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}