package com.example.smarthouse.ui.components

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.smarthouse.R
import com.example.smarthouse.data.enums.Coffee
import com.example.smarthouse.data.enums.DeviceType
import com.example.smarthouse.data.interfaces.Device
import com.example.smarthouse.data.things.AirConditioner
import com.example.smarthouse.data.things.Alarm
import com.example.smarthouse.data.things.AlarmClock
import com.example.smarthouse.data.things.CoffeeMachine
import com.example.smarthouse.data.things.Light
import com.example.smarthouse.ui.components.templates.CreateTemplateComponent
import com.example.smarthouse.ui.components.templates.DeviceTemplateComponent
import com.example.smarthouse.ui.components.templates.DropdownMoreVertTemplate
import com.example.smarthouse.ui.components.things.AirConditionerComponent
import com.example.smarthouse.ui.components.things.AlarmClockComponent
import com.example.smarthouse.ui.components.things.AlarmComponent
import com.example.smarthouse.ui.components.things.CoffeeMachineComponent
import com.example.smarthouse.ui.components.things.LightComponent
import com.example.smarthouse.ui.theme.Purple10
import java.time.LocalTime

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RoomDetails(devices: SnapshotStateList<Device>) {
    val sortedDevices = devices.sortedByDescending {
        when (it) {
            is Light, is Alarm -> 1
            else -> 0
        }
    }
    val dialogOpen = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            Surface(shadowElevation = 5.dp) {
                TopAppBar(
                    title = { Text("Настройки комнаты") },
                    actions = {
                        DropdownMoreVertTemplate {
                            dialogOpen.value = true
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Purple10,
                        titleContentColor = Color.White,
                    ),
                )
            }
        },
        content = {
            val suggestions = DeviceType.entries.toTypedArray()
            var selectedElement by remember {
                mutableStateOf(DeviceType.NONE)
            }
            val alarmPainter = painterResource(id = R.drawable.alarm)
            val lightPainter = painterResource(id = R.drawable.light)
            val alarmClockPainter = painterResource(id = R.drawable.alarm_clock)
            val coffeeMachinePainter = painterResource(id = R.drawable.coffee_machine)
            val conditionerPainter = painterResource(id = R.drawable.conditioner)

            CreateTemplateComponent(
                onClick = { name ->
                    val device = when (selectedElement) {
                        DeviceType.LIGHT -> Light(DeviceType.LIGHT, lightPainter, name, false)
                        DeviceType.COFFEE_MACHINE -> CoffeeMachine(
                            DeviceType.COFFEE_MACHINE,
                            coffeeMachinePainter,
                            name,
                            true,
                            Coffee.NONE,
                            LocalTime.of(7, 0)
                        )
                        DeviceType.ALARM -> Alarm(
                            DeviceType.ALARM,
                            alarmPainter,
                            name,
                            false
                        )

                        DeviceType.ALARM_CLOCK -> AlarmClock(
                            DeviceType.ALARM_CLOCK,
                            alarmClockPainter,
                            name,
                            true,
                            LocalTime.of(7, 0)
                        )
                        DeviceType.AIR_CONDITIONER -> AirConditioner(
                            DeviceType.AIR_CONDITIONER,
                            conditionerPainter,
                            name,
                            false,
                            10.0f
                        )

                        else -> Light(DeviceType.LIGHT, lightPainter, "Свет", false)
                    }
                    devices.add(device)
                    selectedElement = DeviceType.NONE
                },
                dialogOpen = dialogOpen,
                suggestions = suggestions,
                selectedElement = selectedElement,
                getStringValue = { it.translation },
                onValueChange = { selectedElement = it },
                labelName = "Название устройства",
                labelType = "Тип устройства"
            )
            Column(
                modifier = Modifier.padding(top = 60.dp)
            )
            {
                LazyVerticalGrid(
                    GridCells.Fixed(2),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    sortedDevices.forEach { device ->
                        item {
                            DeviceTemplateComponent(
                                image = device.image,
                                name = device.name,
                                onDelete = { devices.remove(device) },
                                content = {
                                    when (device) {
                                        is Light -> LightComponent(light = device)
                                        is AirConditioner -> AirConditionerComponent(airConditioner = device)
                                        is AlarmClock -> AlarmClockComponent(alarmClock = device)
                                        is CoffeeMachine -> CoffeeMachineComponent(coffeeMachine = device)
                                        is Alarm -> AlarmComponent(alarm = device)
                                    }
                                })
                        }
                    }
                }
            }
        }
    )
}

