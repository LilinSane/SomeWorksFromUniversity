package com.example.smarthouse.data.rooms

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.painter.Painter
import com.example.smarthouse.data.enums.RoomType
import com.example.smarthouse.data.interfaces.Device
import com.example.smarthouse.data.things.AirConditioner
import com.example.smarthouse.data.things.AlarmClock
import com.example.smarthouse.data.things.CoffeeMachine
import com.example.smarthouse.data.things.Light

class Room(
    initialRoomType: RoomType,
    val image: Painter,
    val name: String,
    val devices: SnapshotStateList<Device>
){
    companion object {
        private var currentId = 0
        private fun getNextId() = currentId++
    }

    val id: Int = getNextId()
    var roomType by mutableStateOf(initialRoomType)
}

