package com.example.todoapp.ui.screens.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoapp.R
import com.example.todoapp.components.PriorityDropdown
import com.example.todoapp.data.models.Priority
import com.example.todoapp.util.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskContent(
    title: String,
    paddingValues: PaddingValues,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
            .padding(all = Constants.Dimensions.LARGE_PADDING)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { newTitle -> onTitleChange(newTitle) },
            label = { Text(text = stringResource(R.string.l_title)) },
            singleLine = true
        )
        Spacer(
            modifier = Modifier.height(Constants.Dimensions.MEDIUM_PADDING)
        )
        PriorityDropdown(
            priority = priority,
            onPrioritySelected = onPrioritySelected
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description,
            onValueChange = { newDescription -> onDescriptionChange(newDescription) },
            label = { Text(text = stringResource(R.string.l_description)) }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskContentPreview() {
    TaskContent(
        title = "",
        paddingValues = PaddingValues(),
        onTitleChange = {},
        description = "",
        onDescriptionChange = {},
        priority = Priority.LOW,
        onPrioritySelected = {}
    )
}