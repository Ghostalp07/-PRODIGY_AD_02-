package com.example.todo.ROOM


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todo.data.TODO


@Database(entities = [TODO::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao():TodoDao

    companion object {
        @Volatile
        private var INSTANCE: TodoDatabase? = null
        fun getDatabase(context: Context): TodoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    "todo_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}