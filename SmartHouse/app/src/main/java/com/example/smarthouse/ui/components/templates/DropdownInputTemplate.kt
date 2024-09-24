package com.example.smarthouse.ui.components.templates

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun <T> DropdownInputTemplate(
    suggestions: Array<T>,
    selectedElement: T,
    getStringValue: (T) -> String,
    onValueChange: (T) -> Unit,
    label: String
) {
    var expanded by remember { mutableStateOf(false) }
    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column(Modifier.padding(5.dp)) {
        OutlinedTextField(
            value = getStringValue(selectedElement),
            onValueChange = {  },
            modifier = Modifier
                .fillMaxWidth(),
            label = { Text(fontSize = 8.sp, text = label) },
            trailingIcon = {
                Icon(icon, "",
                    Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            suggestions.forEach { element ->
                DropdownMenuItem(
                    text = { Text(text = getStringValue(element)) },
                    onClick = {
                        onValueChange(element)
                        expanded = false
                    }
                )
            }
        }
    }
}