package com.example.smarthouse.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.smarthouse.data.rooms.Room
import com.example.smarthouse.data.things.Alarm
import com.example.smarthouse.data.things.Light
import com.example.smarthouse.ui.components.templates.DeleteTemplateComponent
import com.example.smarthouse.ui.theme.Purple10

@Composable
fun RoomsComponent(rooms: SnapshotStateList<Room?>, onClick: (Room) -> Unit) {
    LazyVerticalGrid(
        GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth()
    ) {
        rooms.forEach { room ->
            if (room != null) {
                item {

                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .clickable { onClick(room!!) },
                        shape = RoundedCornerShape(15.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Purple10),
                            horizontalAlignment = Alignment.CenterHorizontally,

                            ) {
                            DeleteTemplateComponent(
                                onClick = {
                                    if (room != null) {
                                        rooms[room.id] = null
                                    }
                                }
                            )
                            Image(
                                painter = room!!.image,
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(64.dp)
                                    .padding(8.dp)
                            )
                            Text(
                                text = room!!.name,
                                modifier = Modifier.padding(8.dp),
                                color = Color.White
                            )
                        }
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.Start
                        ) {
                            room!!.devices.forEach { device ->
                                when (device) {
                                    is Light, is Alarm -> Text(
                                        text = if (device.status) device.name + ": " + "Включено" else device.name + ": " + "Выключено",
                                        modifier = Modifier.padding(8.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
