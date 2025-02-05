package com.gondroid.wheelsteam.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gondroid.wheelsteam.presentation.model.Category
import com.gondroid.wheelsteam.presentation.model.ItemCar
import com.gondroid.wheelsteam.ui.theme.WheelsTeamTheme


@Composable
fun CardComponent(carItem: ItemCar, onItemSelected: () -> Unit) {

    val iconFavorite: ImageVector =
        if (carItem.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Black)
            .clickable {

            }
    ) {
        // Imagen de fondo

        ImageLoadComponent(
            modifier = Modifier.fillMaxSize(),
            urlImage = carItem.image
        )

        // Gradiente en la parte superior
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Black.copy(alpha = 0.8f), Color.Transparent)
                    )
                )
        )

        Text(
            text = carItem.name,
            color = Color.White,
            fontSize = 18.sp,
            maxLines = 3,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(12.dp)
                .width(200.dp)
                .align(Alignment.TopStart)
        )

        IconButton(
            onClick = { },
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.TopEnd),
        ) {
            Icon(
                imageVector = iconFavorite,
                contentDescription = "Favorite",
                tint = Color.White,
            )
        }

        IconButton(
            onClick = { onItemSelected() },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp),
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Add Task",
                tint = Color.White,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardComponentPreview() {
    WheelsTeamTheme {
        CardComponent(
            carItem = ItemCar(
                name = "Lamborghini Aventador Full Edition 2025 ",
                description = "Un superdeportivo moderno con un motor V12 impresionante.",
                image = "https://tse4.mm.bing.net/th?id=OIP.JugBMBp7ummagJNe8rvC0AHaD4&pid=Api",
                code = "HW5002",
                category = Category("Superdeportivos")
            ),
            onItemSelected = {}
        )
    }
}