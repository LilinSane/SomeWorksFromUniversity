package com.example.smarthouse

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smarthouse.data.enums.Coffee
import com.example.smarthouse.data.enums.DeviceType
import com.example.smarthouse.data.enums.RoomType
import com.example.smarthouse.data.rooms.Room
import com.example.smarthouse.data.things.AirConditioner
import com.example.smarthouse.data.things.Alarm
import com.example.smarthouse.data.things.AlarmClock
import com.example.smarthouse.data.things.CoffeeMachine
import com.example.smarthouse.data.things.Light
import com.example.smarthouse.ui.screens.MainScreen
import com.example.smarthouse.ui.screens.RoomScreen
import java.time.LocalTime

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val alarmPainter = painterResource(id = R.drawable.alarm)
            val lightPainter = painterResource(id = R.drawable.light)
            val alarmClockPainter = painterResource(id = R.drawable.alarm_clock)
            val coffeeMachinePainter = painterResource(id = R.drawable.coffee_machine)
            val conditionerPainter = painterResource(id = R.drawable.conditioner)
            val livingRoom = Room(
                RoomType.LIVING_ROOM,
                painterResource(id = R.drawable.living_room),
                "Зал",
                remember {
                    mutableStateListOf(
                        AirConditioner(
                            DeviceType.AIR_CONDITIONER,
                            conditionerPainter,
                            name = "AUX",
                            false,
                            initialTemperature = 10.0f
                        ),
                        Light(DeviceType.LIGHT, lightPainter, "Свет", true),
                        Alarm(DeviceType.ALARM, alarmPainter, "Сигнализация", true)
                    )
                }
            )
            val bedroom = Room(
                RoomType.BEDROOM,
                painterResource(id = R.drawable.bedroom),
                "Спальня",
                remember {
                    mutableStateListOf(
                        AirConditioner(
                            DeviceType.AIR_CONDITIONER,
                            conditionerPainter,
                            name = "AUX",
                            true,
                            initialTemperature = 10.0f
                        ),
                        Light(DeviceType.LIGHT, lightPainter, "Свет", true),
                        AlarmClock(
                            DeviceType.ALARM_CLOCK,
                            alarmClockPainter,
                            "Casio",
                            true,
                            LocalTime.of(7, 0)
                        ),
                        Alarm(DeviceType.ALARM, alarmPainter, "Сигнализация", true)
                    )
                }
            )
            val kitchen = Room(
                RoomType.KITCHEN,
                painterResource(id = R.drawable.kitchen),
                "Кухня",
                remember {
                    mutableStateListOf(
                        AirConditioner(
                            DeviceType.AIR_CONDITIONER,
                            conditionerPainter,
                            name = "AUX",
                            false,
                            initialTemperature = 10.0f
                        ),
                        Light(DeviceType.LIGHT, lightPainter, "Свет", true),
                        CoffeeMachine(
                            DeviceType.COFFEE_MACHINE,
                            coffeeMachinePainter,
                            "Philips",
                            true,
                            Coffee.NONE,
                            LocalTime.of(7, 0)
                        ),
                        Alarm(DeviceType.ALARM, alarmPainter, "Сигнализация", true)
                    )
                }
            )
            val rooms = remember {
                mutableStateListOf<Room?>(livingRoom, bedroom, kitchen)
            }
            val navController = rememberNavController()
            val mainScreen = "main"
            NavHost(
                navController = navController,
                startDestination = mainScreen
            ) {
                composable(mainScreen) {
                    MainScreen(rooms = rooms) { room ->
                        val route = "room/${room.id}"
                        navController.navigate(route)
                    }
                }
                repeat(100) { index ->
                    val route = "room/${index}"
                    composable(route = route) {
                        rooms[index]?.let { it1 -> RoomScreen(room = it1) }
                    }
                }
            }
        }
    }
}