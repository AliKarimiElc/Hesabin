package com.example.hesabin.repository.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.hesabin.pojo.AccountTransaction

@Dao
abstract class TransactionDao : BaseDao<AccountTransaction> {

    @Query("select * from AccountTransaction")
    abstract fun get(): List<AccountTransaction>

    @Query("select * from AccountTransaction where id=:id")
    abstract fun find(id: Int): AccountTransaction

    @Query("select sum(amount) from AccountTransaction")
    abstract fun balance(): LiveData<Int>
}