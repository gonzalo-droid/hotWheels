package com.gondroid.wheelsteam.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gondroid.wheelsteam.presentation.components.CardComponent
import com.gondroid.wheelsteam.presentation.components.FilterBottomSheet
import com.gondroid.wheelsteam.presentation.components.TopBarComponent
import com.gondroid.wheelsteam.presentation.model.itemCars
import com.gondroid.wheelsteam.ui.theme.WheelsTeamTheme

@Composable
fun HomeScreenRoot(
    onNavigateToProfile: () -> Unit,
    onItemSelected: () -> Unit
) {

    val keyboardController = LocalSoftwareKeyboardController.current


    HomeScreen(onMenuClick = onNavigateToProfile, onItemSelected = onItemSelected)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onMenuClick: () -> Unit, onItemSelected: () -> Unit) {

    var query by remember { mutableStateOf("") }

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarComponent(
                onMenuClick = onMenuClick
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
                HeaderInfo()
                SearchBar(
                    modifier = Modifier.fillMaxWidth(),
                    onShowBottomSheet = { showBottomSheet = true },
                    query = query,
                    onQueryChange = { query = it },
                    onSearch = {}
                )
            }

            items(itemCars) { item ->
                CardComponent(carItem = item, onItemSelected = onItemSelected)
            }

        }

        if (showBottomSheet) {
            FilterBottomSheet(
                sheetState = sheetState,
                onDismiss = { showBottomSheet = false }
            )
        }
    }

}

@Composable
fun HeaderInfo() {
    Column {
        Text(
            text = "Elevate your drive",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onShowBottomSheet: () -> Unit,
    query: String,
    onQueryChange: (String) -> Unit,
    placeholderText: String = "Busca tu auto...",
    onSearch: () -> Unit = {}
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            modifier = Modifier.weight(1f),
            placeholder = { Text(text = placeholderText) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            trailingIcon = {
                if (query.isNotEmpty()) {
                    IconButton(onClick = { onQueryChange("") }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Clear Text"
                        )
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp), // Esquinas redondeadas
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearch()
                    defaultKeyboardAction(ImeAction.Search)
                }
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            )
        )

        IconButton(onClick = onShowBottomSheet) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenRootPreview() {
    WheelsTeamTheme {
        HomeScreen(
            onMenuClick = {},
            onItemSelected = {}
        )
    }
}