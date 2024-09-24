package com.example.smarthouse.ui.components.things

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smarthouse.data.things.Alarm
import com.example.smarthouse.data.things.Light

@Composable
fun AlarmComponent(alarm: Alarm) {
    Text(
        text = if (alarm.status) "Статус: Включено" else "Статус: Выключено",
        modifier = Modifier.padding(8.dp)
    )
    Switch(checked = alarm.status, onCheckedChange = { alarm.status = it })
}