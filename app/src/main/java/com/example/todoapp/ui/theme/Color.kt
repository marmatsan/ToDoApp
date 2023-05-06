package com.example.todoapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Color.Companion.HighPriority: Color
    get() = Color(0xFFFF4646)
val Color.Companion.MediumPriority: Color
    get() = Color(0xFFFFC114)
val Color.Companion.LowPriority: Color
    get() = Color(0xFF00C980)
val Color.Companion.NonePriority: Color
    get() = Color(0xFFFFFFFF)