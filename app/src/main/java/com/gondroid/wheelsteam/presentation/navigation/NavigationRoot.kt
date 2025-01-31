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
import com.gondroid.wheelsteam.presentation.LoginScreenRoot
import com.gondroid.wheelsteam.presentation.ProfileScreenRoot
import com.gondroid.wheelsteam.presentation.onboarding.Onboarding0neScreenRoot
import com.gondroid.wheelsteam.presentation.onboarding.OnboardingTwoScreenRoot


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
            startDestination = if (shouldShowOnboarding) Onboarding0neScreenRoute else LoginScreenRoute
        ) {
            composable<Onboarding0neScreenRoute> {
                Onboarding0neScreenRoot(
                    onNavigateNext = {
                        navHostController.navigate(LoginScreenRoute)
                    },
                    onSkip = {
                        navHostController.navigate(LoginScreenRoute)
                    }
                )
            }

            composable<LoginScreenRoute> {
                LoginScreenRoot()
            }

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
                CollectionScreenRoot(
                    onNavigateUp = {
                        navHostController.navigateUp()
                    },
                    onItemSelected = {
                    }
                )
            }
        }
    }
}