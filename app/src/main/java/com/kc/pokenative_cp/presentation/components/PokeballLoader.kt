package com.kc.pokenative_cp.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInQuad
import androidx.compose.animation.core.EaseOutQuad
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kc.pokenative_cp.R

@Composable
fun PokeballLoader() {
    val bounceAnim = remember { Animatable(0f) }  // rebound animation

    LaunchedEffect(Unit) {
        while (true) {
            bounceAnim.animateTo(
                targetValue = -40f, // up to -40 pixels
                animationSpec = tween(durationMillis = 500, easing = EaseOutQuad)
            )
            bounceAnim.animateTo(
                targetValue = 0f, // down to 0
                animationSpec = tween(durationMillis = 500, easing = EaseInQuad)
            )
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo_pokeball),
            contentDescription = "Pokéball Loader",
            modifier = Modifier
                .size(64.dp)
                .offset(y = bounceAnim.value.dp)
        )
    }
}

@Preview
@Composable
private fun BouncingPokeballLoaderPreview() {
    MaterialTheme {
        PokeballLoader()
    }
}
