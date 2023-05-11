package com.example.todoapp.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.ToDoTask
import com.example.todoapp.data.models.Priority
import com.example.todoapp.data.repositories.ToDoRepository
import com.example.todoapp.util.Constants.Empty
import com.example.todoapp.util.RequestState
import com.example.todoapp.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
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

    private val _requestState: MutableStateFlow<RequestState<*>> by lazy {
        MutableStateFlow(
            RequestState.Idle
        )
    }
    val requestState: StateFlow<RequestState<*>>
        get() = _requestState

    fun getAllTasks() {
        viewModelScope.launch {
            _requestState.update { RequestState.Loading }
            repository
                .getAllTasks()
                .onCompletion { exception ->
                    if (exception != null) _requestState.update { RequestState.Error(exception) }
                }
                .collectLatest { taskList ->
                    _requestState.update { RequestState.Success(taskList) }
                }
        }
    }

    private val _selectedTask: MutableStateFlow<ToDoTask?> by lazy { MutableStateFlow(null) }
    val selectedTask: StateFlow<ToDoTask?>
        get() = _selectedTask

    fun getSelectedTask(taskId: Int) {
        viewModelScope.launch {
            repository
                .getSelectedTask(taskId = taskId)
                .collectLatest { task ->
                    _selectedTask.update { task }
                }
        }
    }

    // TaskContent
    private val _id: MutableStateFlow<Int> by lazy { MutableStateFlow(0) }
    private val _title: MutableStateFlow<String> by lazy { MutableStateFlow(String.Empty) }
    private val _description: MutableStateFlow<String> by lazy { MutableStateFlow(String.Empty) }
    private val _priority: MutableStateFlow<Priority> by lazy { MutableStateFlow(Priority.LOW) }

    val id: StateFlow<Int>
        get() = _id
    val title: StateFlow<String>
        get() = _title
    val description: StateFlow<String>
        get() = _description
    val priority: StateFlow<Priority>
        get() = _priority

    fun updateId(newId: Int) {
        viewModelScope.launch {
            _id.update { newId }
        }
    }

    fun updateTitle(newTitle: String) {
        viewModelScope.launch {
            _title.update { newTitle }
        }
    }

    fun updateDescription(newDescription: String) {
        viewModelScope.launch {
            _description.update { newDescription }
        }
    }

    fun updatePriority(newPriority: Priority) {
        viewModelScope.launch {
            _priority.update { newPriority }
        }
    }

    fun updateTaskFields(selectedTask: ToDoTask?) {
        updateId(newId = selectedTask?.id ?: 0)
        updateTitle(newTitle = selectedTask?.title ?: String.Empty)
        updateDescription(newDescription = selectedTask?.description ?: String.Empty)
        updatePriority(newPriority = selectedTask?.priority ?: Priority.LOW)
    }

}