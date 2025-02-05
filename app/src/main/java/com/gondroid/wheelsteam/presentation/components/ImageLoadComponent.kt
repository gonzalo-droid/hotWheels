package com.gondroid.wheelsteam.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.gondroid.wheelsteam.R


@Composable
fun ImageLoadComponent(modifier: Modifier, urlImage: String) {
    val placeholder: Painter = painterResource(R.drawable.placeholder_item) // Imagen mientras carga
    val errorImage: Painter = painterResource(R.drawable.error_item) // Imagen en caso de error

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(urlImage) // URL incorrecta para forzar error
            .crossfade(true)
            .diskCachePolicy(CachePolicy.ENABLED) // Habilita caché en disco
            .memoryCachePolicy(CachePolicy.ENABLED) // Habilita caché en memoria
            .build(),
        contentDescription = "Auto hot wheels",
        placeholder = placeholder,
        contentScale = ContentScale.Crop,
        error = errorImage,
        modifier = modifier
    )
}


