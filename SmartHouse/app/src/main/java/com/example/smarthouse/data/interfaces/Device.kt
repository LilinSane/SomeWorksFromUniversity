package com.example.smarthouse.data.interfaces

import androidx.compose.ui.graphics.painter.Painter
import com.example.smarthouse.data.enums.DeviceType
import com.example.smarthouse.data.enums.RoomType

interface Device{
    val deviceType: DeviceType
    val image: Painter
    val name: String
    val status: Boolean
}