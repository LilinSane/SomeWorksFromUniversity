package com.example.smarthouse.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.smarthouse.R
import com.example.smarthouse.data.enums.DeviceType
import com.example.smarthouse.data.enums.RoomType
import com.example.smarthouse.data.rooms.Room
import com.example.smarthouse.data.things.Alarm
import com.example.smarthouse.data.things.Light
import com.example.smarthouse.ui.components.RoomsComponent
import com.example.smarthouse.ui.components.templates.CreateTemplateComponent
import com.example.smarthouse.ui.components.templates.DropdownMoreVertTemplate
import com.example.smarthouse.ui.theme.Purple10

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(rooms: SnapshotStateList<Room?>, onClick: (Room) -> Unit) {
    val dialogOpen = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            Surface(shadowElevation = 5.dp) {
                TopAppBar(
                    title = { Text("Главный экран") },
                    actions = {
                        DropdownMoreVertTemplate {
                            dialogOpen.value = true
                        }
                    },
                    colors = topAppBarColors(
                        containerColor = Purple10,
                        titleContentColor = Color.White,
                    ),
                )
            }
        },
        content = {
            val suggestions = RoomType.entries.toTypedArray()
            var selectedElement by remember {
                mutableStateOf(RoomType.NONE)
            }
            val kitchenPainter = painterResource(id = R.drawable.kitchen)
            val bedroomPainter = painterResource(id = R.drawable.bedroom)
            val livingRoomPainter = painterResource(id = R.drawable.living_room)
            val alarmPainter = painterResource(id = R.drawable.alarm)
            val lightPainter = painterResource(id = R.drawable.light)
            CreateTemplateComponent(
                onClick = { name ->
                    val room = Room(
                        selectedElement,
                        when (selectedElement) {
                            RoomType.LIVING_ROOM -> livingRoomPainter
                            RoomType.KITCHEN -> kitchenPainter
                            else -> bedroomPainter
                        },
                        name,
                        mutableStateListOf(
                            Light(DeviceType.LIGHT, lightPainter, "Свет", false),
                            Alarm(DeviceType.ALARM, alarmPainter, "Сигнализация", false)
                        )
                    )
                    rooms.add(room)
                    selectedElement = RoomType.NONE
                },
                dialogOpen = dialogOpen,
                suggestions = suggestions,
                selectedElement = selectedElement,
                getStringValue = { it.translation },
                onValueChange = { selectedElement = it },
                labelName = "Название комнаты",
                labelType = "Тип комнаты"
            )
            Column(
                modifier = Modifier.padding(top = 60.dp)
            ) {
                RoomsComponent(
                    rooms = rooms,
                    onClick = onClick
                )
            }
        }
    )
}