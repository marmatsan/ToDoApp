package com.example.todoapp.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todoapp.data.models.Priority
import com.example.todoapp.util.Constants

@Composable
fun PriorityItem(
    priority: Priority,
    onItemClicked: () -> Unit
) {
    DropdownMenuItem(
        text = { Text(text = priority.name) },
        onClick = { onItemClicked() },
        leadingIcon = {
            Canvas(modifier = Modifier.size(Constants.Dimensions.PRIORITY_INDICATOR_SIZE)) {
                drawCircle(color = priority.color)
            }
        }
    )
}