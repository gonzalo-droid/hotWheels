package com.gondroid.wheelsteam.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import com.gondroid.wheelsteam.presentation.components.CollectionComponent
import com.gondroid.wheelsteam.presentation.model.collectionsCar
import com.gondroid.wheelsteam.ui.theme.WheelsTeamTheme


@Composable
fun CollectionScreenRoot(
    onNavigateUp: () -> Unit,
    onItemSelected: () -> Unit
) {
    CollectionScreen(onNavigateUp = onNavigateUp, onItemSelected = onItemSelected)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollectionScreen(onNavigateUp: () -> Unit, onItemSelected: () -> Unit) {
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
                    text = "My Collections",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
            }

            items(collectionsCar) { item ->
                CollectionComponent(item = item, onItemSelected = {})
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun CollectionScreenRootPreview() {
    WheelsTeamTheme {
        CollectionScreen(onNavigateUp = {}, onItemSelected = { })
    }
}