package com.example.unit6_pathway3_project_flight_search.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Airport::class, Favorite::class], version = 1, exportSchema = false)
abstract class AirportDatabase : RoomDatabase() {
    abstract fun airportDao(): AirportDao
    abstract fun FavoriteDao(): FavoriteDao

    companion object {
        @Volatile
        private var Instance: AirportDatabase? = null

        fun getDatabase(context: Context): AirportDatabase {
            return Instance ?: synchronized(this) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    AirportDatabase::class.java,
                    "flight_search"
                )

                // Chỉ copy từ assets nếu database chưa tồn tại
                val dbFile = context.applicationContext.getDatabasePath("flight_search")
                if (!dbFile.exists()) {
                    builder.createFromAsset("database/flight_search.db")
                }

                builder.fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}