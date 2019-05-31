package com.example.hesabin.repository.model.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<T> {

    @Insert
    fun insert(t: T) : Long

    @Insert
    fun insert(t: List<T>) : List<Long>

    @Insert
    fun insert(vararg t: T) : List<Long>

    @Delete
    fun delete(t: T) : Int

    @Update
    fun update(t: T) : Int
}