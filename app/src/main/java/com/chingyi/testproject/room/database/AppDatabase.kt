package com.chingyi.testproject.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.chingyi.testproject.room.dao.FavouriteMovieDao
import com.chingyi.testproject.room.dao.MovieTableDao
import com.chingyi.testproject.room.enity.FavouriteMovieTable
import com.chingyi.testproject.room.enity.MovieTable

@Database(entities = [MovieTable::class, FavouriteMovieTable::class],
    version = 2,
    exportSchema= false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieTableDao(): MovieTableDao
    abstract fun movieFavouriteTableDao(): FavouriteMovieDao

    companion object {
        const val DB_NAME = "movie_db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DB_NAME
                ).allowMainThreadQueries().build()

                INSTANCE = instance
                return instance
            }
        }
    }
}