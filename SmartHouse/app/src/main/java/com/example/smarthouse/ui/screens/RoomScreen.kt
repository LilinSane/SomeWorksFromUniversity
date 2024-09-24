package com.example.smarthouse.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import com.example.smarthouse.data.rooms.Room
import com.example.smarthouse.ui.components.RoomDetails

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RoomScreen(room: Room){
    RoomDetails(devices = room.devices)
}