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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gondroid.wheelsteam.R
import com.gondroid.wheelsteam.ui.theme.WheelsTeamTheme

@Composable
fun Onboarding0neScreenRoot(onNavigateNext: () -> Unit, onSkip: () -> Unit) {
    Onboarding0neScreen(onNavigateNext = onNavigateNext, onSkip = onSkip)
}

@Composable
fun Onboarding0neScreen(onNavigateNext: () -> Unit, onSkip: () -> Unit) {


    var position by remember { mutableIntStateOf(0) }

    val listPages = listOf(
        OnboardingPage(
            position = 0,
            message = "Desde clásicos exóticos hasta lujosos deportivos",
            imageBackground = R.drawable.onboarding_03,
            textAlign = TextAlign.Start,
            alignment = Alignment.BottomStart,
        ), OnboardingPage(
            position = 1,
            message = "Encuentra piezas únicas y eleva tu colección a otro nivel",
            imageBackground = R.drawable.onboarding_04,
            textAlign = TextAlign.Center,
            alignment = Alignment.TopCenter
        ), OnboardingPage(
            position = 2,
            message = "Conéctate con coleccionistas de todo el mundo",
            imageBackground = R.drawable.onboarding_02,
            textAlign = TextAlign.End,
            alignment = Alignment.Center
        )
    )


    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = listPages[position].imageBackground),
            contentDescription = "Logo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.9f))
                    )
                )
        )

        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()

        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 100.dp, top = 100.dp),
            ) {
                Text(
                    modifier = Modifier.align(listPages[position].alignment),
                    text = listPages[position].message,
                    style = MaterialTheme.typography.displayMedium,
                    color = Color.White,
                    textAlign = listPages[position].textAlign,
                    fontWeight = FontWeight.Light
                )
            }



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        if (position <= 0) {
                            onSkip()
                        } else {
                            position--
                        }
                    }, modifier = Modifier, shape = RoundedCornerShape(8.dp)
                ) {
                    val message = if (position == 0) "Saltar" else "Anterior"
                    Text(text = message)
                }
                Button(
                    onClick = {
                        if (position >= 2) {
                            onNavigateNext()
                        } else {
                            position++
                        }
                    }, modifier = Modifier, shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Siguiente")

                }
            }
        }
    }
}

data class OnboardingPage(
    var position: Int,
    var message: String,
    var imageBackground: Int,
    var textAlign: TextAlign,
    var alignment: Alignment
)


@Preview(showBackground = true)
@Composable
fun Onboarding0neScreenRootPreview() {
    WheelsTeamTheme {
        Onboarding0neScreen(onNavigateNext = {}, onSkip = {})
    }
}