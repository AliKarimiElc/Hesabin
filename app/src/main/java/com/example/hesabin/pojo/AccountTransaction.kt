package com.example.hesabin.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    foreignKeys = [ForeignKey(
        entity = TransactionCategory::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("Cat_Id")
    )]
)
data class AccountTransaction(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var amount: Int? = null,
    var description: String? = null,

    @ColumnInfo(name = "Cat_Id", index = true)
    var categoryId: Int? = null
) : Serializable