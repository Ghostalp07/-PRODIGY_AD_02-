package com.example.todo.ROOM

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todo.data.TODO
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    fun selectAll(): Flow<List<TODO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: TODO)

    @Query("Delete From todo WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM todo")
    suspend fun deleteAllTodo()

    @Query("UPDATE todo SET isComplete = :isComplete WHERE id = :id")
    suspend fun updateTodo(isComplete: Boolean, id: Long)


}