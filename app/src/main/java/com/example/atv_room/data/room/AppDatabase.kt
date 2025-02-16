package com.example.atv_room.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.atv_room.data.dao.ProductDAO
import com.example.atv_room.data.model.ProductModel

@Database(entities= [ProductModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        private lateinit var INSTANCE: AppDatabase

        fun getDatabase(context: Context): AppDatabase{

            if(!::INSTANCE.isInitialized){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "mydatabase.db")
                        .allowMainThreadQueries()
                        .build()
                }
            }

            return INSTANCE
        }
    }

    abstract fun ProductDAO(): ProductDAO
}