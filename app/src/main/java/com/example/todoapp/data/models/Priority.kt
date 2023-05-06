package com.example.todoapp.data.models

import androidx.compose.ui.graphics.Color
import com.example.todoapp.ui.theme.HighPriority
import com.example.todoapp.ui.theme.MediumPriority
import com.example.todoapp.ui.theme.LowPriority
import com.example.todoapp.ui.theme.NonePriority

enum class Priority(val color: Color) {
    HIGH(color = Color.HighPriority),
    MEDIUM(color = Color.MediumPriority),
    LOW(color = Color.LowPriority),
    NONE(color = Color.NonePriority);
}