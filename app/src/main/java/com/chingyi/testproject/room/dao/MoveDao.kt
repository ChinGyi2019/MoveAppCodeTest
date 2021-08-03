package com.chingyi.testproject.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chingyi.testproject.room.enity.MovieTable


@Dao
interface MovieTableDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movies : MovieTable)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies : List<MovieTable>)

    @Query("SELECT * FROM MovieTable WHERE movieType = :movieType")
    suspend fun getMovies(movieType : String) : List<MovieTable>

    @Query("SELECT * FROM MovieTable WHERE id = :id")
    suspend fun getMovie(id : Long) : MovieTable
}
