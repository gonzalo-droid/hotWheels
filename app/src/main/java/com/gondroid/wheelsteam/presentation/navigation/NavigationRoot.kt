package com.gondroid.wheelsteam.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gondroid.wheelsteam.presentation.CollectionScreenRoot
import com.gondroid.wheelsteam.presentation.DetailScreenRoot
import com.gondroid.wheelsteam.presentation.FavoriteScreenRoot
import com.gondroid.wheelsteam.presentation.HomeScreenRoot
import com.gondroid.wheelsteam.presentation.ProfileScreenRoot


@Composable
fun NavigationRoot(
    shouldShowOnboarding: Boolean,
    navHostController: NavHostController,
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navHostController,
            startDestination = HomeScreenRoute //if (shouldShowOnboarding) "onboarding" else "home"
        ) {
            composable<HomeScreenRoute> {
                HomeScreenRoot(
                    onNavigateToProfile = {
                        navHostController.navigate(ProfileScreenRoute)
                    },
                    onItemSelected = {
                        navHostController.navigate(DetailScreenRoute)
                    }
                )
            }
            composable<ProfileScreenRoute> {
                ProfileScreenRoot(
                    onNavigateToFavorite = {
                        navHostController.navigate(FavoriteScreenRoute)
                    },
                    onNavigateToCollection = {
                        navHostController.navigate(CollectionScreenRoute)
                    },
                    onNavigateUp = {
                        navHostController.navigateUp()
                    }
                )
            }
            composable<DetailScreenRoute> {
                DetailScreenRoot()
            }
            composable<FavoriteScreenRoute> {
                FavoriteScreenRoot(
                    onNavigateUp = {
                        navHostController.navigateUp()
                    },
                    onItemSelected = {
                        navHostController.navigate(DetailScreenRoute)
                    }
                )
            }
            composable<CollectionScreenRoute> {
                CollectionScreenRoot()
            }
        }
    }
}