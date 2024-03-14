package com.example.todo.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.Graph
import com.example.todo.data.TODO
import com.example.todo.data.TODOdata
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class HomeViewModel (private val tododata: TODOdata= Graph.todoRepo):ViewModel(){
    private val _state = MutableStateFlow(HomeViewState())
    val state: StateFlow<HomeViewState>
        get() = _state
    val todoList=tododata.selectAll
    val selected =MutableStateFlow(state.value.selected)
    init {
        viewModelScope.launch {
            combine(todoList, selected) { todoList: List<TODO>, selected: Boolean ->
                HomeViewState(todoList, selected)
            }.collect {
                _state.value = it
            }
        }
    }

    fun updateTodo(selected: Boolean, id: Long) = viewModelScope.launch {
        tododata.updateTodo(selected, id)
    }

    fun delete(todo: TODO) = viewModelScope.launch {
        tododata.deleteTodo(todo)
    }



}

data class HomeViewState(
    val todoList: List<TODO> = emptyList(),
    val selected: Boolean = false,
)