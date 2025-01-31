package com.gondroid.wheelsteam.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector


data class TopLevelRoute<T : Any>(val name: String, val route: T, val icon: ImageVector)

val topLevelRoutes = listOf(
    TopLevelRoute("Profile", ProfileScreenRoute, Icons.Default.Face),
    TopLevelRoute("Home", HomeScreenRoute, Icons.Default.Home)
)