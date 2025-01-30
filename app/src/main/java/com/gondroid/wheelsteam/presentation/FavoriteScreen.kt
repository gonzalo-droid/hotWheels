package com.gondroid.wheelsteam.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gondroid.wheelsteam.presentation.components.CardComponent
import com.gondroid.wheelsteam.presentation.model.itemCars

@Composable
fun FavoriteScreenRoot(
    onNavigateUp: () -> Unit,
    onItemSelected: () -> Unit
) {
    FavoriteScreen(onNavigateUp = onNavigateUp, onItemSelected = onItemSelected)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(onNavigateUp: () -> Unit, onItemSelected: () -> Unit) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier,
                title = { Text(text = "") },
                navigationIcon = {
                    IconButton(onClick = onNavigateUp) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onSurface,
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)

        ) {
            item {
                Text(
                    text = "My Favorites",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
            }

            items(itemCars.filter { it.isFavorite }) { item ->
                CardComponent(carItem = item, onItemSelected = onItemSelected)
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun FavoriteScreenRootPreview() {
    FavoriteScreen(
        onNavigateUp = {},
        onItemSelected = {}
    )
}