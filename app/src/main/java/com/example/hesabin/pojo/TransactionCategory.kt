package com.example.hesabin.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = TransactionCategory::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("Parent_Cat_Id")
    )]
)
data class TransactionCategory(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "Parent_Cat_Id",index = true)
    var parentCategoryId: Int? = null,
    var description: String? = null
)