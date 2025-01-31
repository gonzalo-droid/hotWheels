package com.gondroid.wheelsteam.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gondroid.wheelsteam.R
import com.gondroid.wheelsteam.ui.theme.WheelsTeamTheme

@Composable
fun OnboardingThreeScreenRoot(onNavigateNext: () -> Unit, onPrevious: () -> Unit) {
    OnboardingThreeScreen(onNavigateNext = onNavigateNext, onPrevious = onPrevious)
}

@Composable
fun OnboardingThreeScreen(onNavigateNext: () -> Unit, onPrevious: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.onboarding_03),
            contentDescription = "Logo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.4f))
                    )
                )
        ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onPrevious,
                    modifier = Modifier,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Anterior")
                }
                Button(
                    onClick = onNavigateNext,
                    modifier = Modifier,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Siguiente")

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun OnboardingThreeScreenRootPreview() {
    WheelsTeamTheme {
        OnboardingThreeScreen(onNavigateNext = {}, onPrevious = {})
    }
}