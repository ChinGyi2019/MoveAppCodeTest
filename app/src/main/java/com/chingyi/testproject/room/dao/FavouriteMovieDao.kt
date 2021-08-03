package com.chingyi.testproject.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chingyi.testproject.room.enity.FavouriteMovieTable
import com.chingyi.testproject.room.enity.MovieTable

@Dao
interface FavouriteMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setFavourite(movie : FavouriteMovieTable)

    @Query("SELECT * FROM FavouriteMovieTable WHERE id = :id")
    fun isFavouriteMovie(id : Long
    ): FavouriteMovieTable
}