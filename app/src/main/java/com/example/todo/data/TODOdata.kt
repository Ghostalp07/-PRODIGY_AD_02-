package com.example.todo.data

import com.example.todo.ROOM.TodoDao
import kotlinx.coroutines.Dispatchers

class TODOdata(private val todoDao: TodoDao){
    val selectAll = todoDao.selectAll()
    suspend fun insertTodo(todo: TODO){
Dispatchers.IO.apply {
    todoDao.insert(todo)
}
    }
    suspend fun deleteTodo(todo: TODO){
        Dispatchers.IO.apply {
            todoDao.delete(todo.id)
        }
    }
    suspend fun updateTodo(isComplete: Boolean, id: Long) {
        Dispatchers.IO.apply {
            todoDao.updateTodo(isComplete, id)
        }
    }


}
