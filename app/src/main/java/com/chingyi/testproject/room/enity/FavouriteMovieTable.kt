package com.chingyi.testproject.room.enity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavouriteMovieTable (
    @PrimaryKey
    val id: Long? = null,
    val isFavourite: Boolean? = false)