package com.example.todo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TODO(
    val todo: String,
    val time: String,
    val isComplete: Boolean = false,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
)