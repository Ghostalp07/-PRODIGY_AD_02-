package com.example.todo

import android.content.Context
import com.example.todo.ROOM.TodoDatabase
import com.example.todo.data.TODOdata

object Graph {
    lateinit var database: TodoDatabase
        private set
    val todoRepo by lazy {
        TODOdata(database.todoDao())
    }

    fun provide(context: Context) {
        database = TodoDatabase.getDatabase(context)
    }
}