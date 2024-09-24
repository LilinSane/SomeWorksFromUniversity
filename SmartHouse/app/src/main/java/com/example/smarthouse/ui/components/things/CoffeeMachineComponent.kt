package com.example.smarthouse.ui.components.things

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.smarthouse.data.enums.Coffee
import com.example.smarthouse.data.things.CoffeeMachine
import com.example.smarthouse.ui.components.templates.DropdownInputTemplate
import com.example.smarthouse.ui.theme.Purple10
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockConfig
import com.maxkeppeler.sheets.clock.models.ClockSelection
import java.time.LocalTime


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeMachineComponent(coffeeMachine: CoffeeMachine) {
    Text(
        text = if (coffeeMachine.status) "Статус: Включено" else "Статус: Выключено",
        modifier = Modifier.padding(8.dp)
    )
    Switch(
        checked = coffeeMachine.status,
        onCheckedChange = { coffeeMachine.status = it }
    )

    if (coffeeMachine.status) {
        Text(
            text = "Время начала работы: " + coffeeMachine.time,
            modifier = Modifier.padding(8.dp, 12.dp, 8.dp, 8.dp)
        )

        val clockState = rememberSheetState()
        clockState.visible = false

        ClockDialog(state = clockState,
            config = ClockConfig(
                defaultTime = LocalTime.of(8, 0)
            ),
            selection = ClockSelection.HoursMinutes { hours, minutes ->
                coffeeMachine.time = LocalTime.of(hours, minutes)
            })

        Column {
            Button(
                onClick = {
                    clockState.show()
                }) {
                Text(text = "Установить время")
            }
        }
        val suggestions = Coffee.entries.toTypedArray()

        DropdownInputTemplate(
            suggestions = suggestions,
            selectedElement = coffeeMachine.coffee,
            getStringValue = { it.translation },
            onValueChange = { coffeeMachine.coffee = it },
            label = "Выберите напиток"
        )
    }
}
