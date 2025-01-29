package com.gondroid.wheelsteam.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.gondroid.wheelsteam.presentation.model.Category
import com.gondroid.wheelsteam.presentation.model.ItemCar
import com.gondroid.wheelsteam.ui.theme.WheelsTeamTheme

@Composable
fun CardComponent(car: ItemCar, onNextClick: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Black)
            .clickable { }
    ) {
        // Imagen de fondo
        AsyncImage(
            model = car.image,
            contentDescription = car.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Gradiente en la parte superior
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Black.copy(alpha = 0.8f), Color.Transparent)
                    )
                )
        )

        // Nombre del auto en la parte superior derecha
        Text(
            text = car.name,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(12.dp)
        )


        IconButton(onClick = { }, modifier  = Modifier
            .align(Alignment.BottomEnd)
            .padding(12.dp),) {
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
        CardComponent(car = ItemCar(
            name = "Lamborghini Aventador",
            description = "Un superdeportivo moderno con un motor V12 impresionante.",
            image = "https://tse4.mm.bing.net/th?id=OIP.JugBMBp7ummagJNe8rvC0AHaD4&pid=Api",
            code = "HW5002",
            category = Category("Superdeportivos")
        ), onNextClick = {})
    }
}