package com.example.hesabin.repository.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.hesabin.pojo.AccountTransaction
import com.example.hesabin.pojo.TransactionCategory
import com.example.hesabin.repository.model.dao.CategoryDao
import com.example.hesabin.repository.model.dao.TransactionDao
import java.util.concurrent.Executors

@Database(entities = [TransactionCategory::class, AccountTransaction::class], version = 4)
abstract class ApplicationRoom : RoomDatabase() {

    abstract fun categories(): CategoryDao
    abstract fun transactions(): TransactionDao

    companion object {
        private var roomInstance: ApplicationRoom? = null
        @Synchronized
        fun getInstance(context: Context): ApplicationRoom {
            if (roomInstance == null) {
                roomInstance =
                    Room.databaseBuilder(context.applicationContext, ApplicationRoom::class.java, "NoteDatabase")
                        .allowMainThreadQueries().fallbackToDestructiveMigration()
                        .addCallback(seedDataBase(context))
                        .build()
            }
            return roomInstance as ApplicationRoom
        }

        private fun seedDataBase(context: Context): Callback {
            return object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Executors.newSingleThreadScheduledExecutor().execute(Runnable {
                        val categories = getInstance(context).categories()
                        categories.insert(TransactionCategory(null, null, "پوشاک"))
                        categories.insert(TransactionCategory(null, null, "غذا"))
                        categories.insert(TransactionCategory(null, null, "تنقلات"))
                        categories.insert(TransactionCategory(null, null, "تفریح و سرگرمی"))
                        categories.insert(TransactionCategory(null, null, "رفت و آمد"))
                        categories.insert(TransactionCategory(null, null, "تعمیرات"))
                        categories.insert(TransactionCategory(null, null, "آموزش"))
                        categories.insert(TransactionCategory(null, null, "بهداشت و سلامت"))
                        categories.insert(TransactionCategory(null, null, "درمان"))
                    })
                }
            }
        }
    }
}