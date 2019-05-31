package com.example.hesabin.repository.model.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.hesabin.pojo.TransactionCategory

@Dao
abstract class CategoryDao : BaseDao<TransactionCategory> {

    @Query("select * from TransactionCategory")
    abstract fun get(): List<TransactionCategory>

    @Query("select * from TransactionCategory where id=:id")
    abstract fun find(id: Int): TransactionCategory

}