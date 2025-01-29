package com.gondroid.wheelsteam.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TopBarComponent() {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier,
                    text = "Hot Wheels",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }

        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Add Task",
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
        actions = {
            Spacer(modifier = Modifier.width(60.dp)) // Espacio adicional si se requiere
        },
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarComponentPreview() {
    TopBarComponent()
}
