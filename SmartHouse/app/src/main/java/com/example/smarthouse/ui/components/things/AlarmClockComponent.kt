package com.example.smarthouse.ui.components.things

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.smarthouse.data.things.AlarmClock
import com.example.smarthouse.ui.theme.Purple10
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockConfig
import com.maxkeppeler.sheets.clock.models.ClockSelection
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AlarmClockComponent(alarmClock: AlarmClock) {
    Text(
        text = if (alarmClock.status) "Статус: Включено" else "Статус: Выключено",
        modifier = Modifier.padding(8.dp)
    )
    Switch(
        checked = alarmClock.status,
        onCheckedChange = { alarmClock.status = it }
    )

    if (alarmClock.status) {
        Text(
            text = "Время: " + alarmClock.time,
            modifier = Modifier.padding(8.dp, 12.dp, 8.dp, 8.dp)
        )
        val clockState = rememberSheetState()
        clockState.visible = false

        ClockDialog(state = clockState,
            config = ClockConfig(
                defaultTime = LocalTime.of(8, 0)
            ),
            selection = ClockSelection.HoursMinutes { hours, minutes ->
                alarmClock.time = LocalTime.of(hours, minutes)
            })

        Column {
            Button(
                onClick = {
                    clockState.show()
                }) {
                Text(text = "Установить время")
            }
        }
    }
}