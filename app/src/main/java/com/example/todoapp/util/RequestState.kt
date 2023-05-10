package com.example.todoapp.util

import com.example.todoapp.data.ToDoTask

sealed class RequestState<out T> {
    object Idle : RequestState<Nothing>()
    object Loading : RequestState<Nothing>()
    data class Success(val data: List<ToDoTask>) : RequestState<List<ToDoTask>>()
    data class Error<T>(val error: T) : RequestState<T>()
}
