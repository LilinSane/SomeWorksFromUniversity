package com.example.smarthouse.data.things

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import com.example.smarthouse.data.enums.DeviceType
import com.example.smarthouse.data.enums.RoomType
import com.example.smarthouse.data.interfaces.Device
import java.time.LocalTime

class AlarmClock(
    initialDeviceType: DeviceType,
    override val image: Painter,
    override val name: String,
    initialStatus: Boolean,
    initialTime: LocalTime
) : Device {
    override var status by mutableStateOf(initialStatus)
    override val deviceType by mutableStateOf(initialDeviceType)
    var time by mutableStateOf(initialTime)
}