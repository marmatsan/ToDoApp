package com.example.todoapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.ToDoTask
import com.example.todoapp.data.repositories.ToDoRepository
import com.example.todoapp.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel() {

    // AppBar State
    private val _searchAppBarState by lazy { MutableStateFlow(SearchAppBarState.CLOSED) }

    val searchAppBarState: StateFlow<SearchAppBarState>
        get() = _searchAppBarState

    fun setSearchAppbarState(newState: SearchAppBarState) {
        viewModelScope.launch(Dispatchers.Main) {
            _searchAppBarState.update { newState }
        }
    }

    // Search AppBar text state
    private val _searchTextState by lazy { MutableStateFlow(String()) }

    val searchTextState: StateFlow<String>
        get() = _searchTextState

    fun setSearchTextState(newText: String) {
        viewModelScope.launch(Dispatchers.Main) {
            _searchTextState.update { newText }
        }
    }

    private val _allTasks by lazy { MutableStateFlow<List<ToDoTask>>(emptyList()) }
    val allTasks: StateFlow<List<ToDoTask>>
        get() = _allTasks

    fun getAllTasks() {
        viewModelScope.launch {
            repository.getAllTasks().collectLatest { taskList ->
                _allTasks.update { taskList }
            }
        }
    }

}