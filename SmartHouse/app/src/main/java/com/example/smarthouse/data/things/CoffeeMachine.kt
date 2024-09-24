package com.example.smarthouse.data.things

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import com.example.smarthouse.data.enums.Coffee
import com.example.smarthouse.data.enums.DeviceType
import com.example.smarthouse.data.enums.RoomType
import com.example.smarthouse.data.interfaces.Device
import java.time.LocalTime

class CoffeeMachine(
    initialDeviceType: DeviceType,
    override val image: Painter,
    override val name: String,
    initialStatus: Boolean,
    initialCoffee: Coffee,
    initialTime: LocalTime
) : Device {
    override val deviceType by mutableStateOf(initialDeviceType)
    override var status by mutableStateOf(initialStatus)
    var time by mutableStateOf(initialTime)
    var coffee by mutableStateOf(initialCoffee)
}