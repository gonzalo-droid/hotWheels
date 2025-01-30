package com.gondroid.wheelsteam.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gondroid.wheelsteam.presentation.model.CollectionCar
import com.gondroid.wheelsteam.ui.theme.WheelsTeamTheme


@Composable
fun CollectionComponent(item: CollectionCar, onItemSelected: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(12.dp)
            .clickable {

            }
    ) {


        Text(
            text = item.name,
            color = Color.White,
            fontSize = 18.sp,
            maxLines = 3,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding()
                .align(Alignment.TopStart)
        )


        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.onSurface)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = "5",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)

            )
        }

        IconButton(
            onClick = { onItemSelected() },
            modifier = Modifier
                .align(Alignment.BottomEnd),
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Task",
                tint = Color.White,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CollectionComponentPreview() {

    WheelsTeamTheme {
        CollectionComponent(
            item = CollectionCar(
                name = "Lamborghini Aventador Full Edition 2025 ",
            ),
            onItemSelected = {}
        )
    }
}