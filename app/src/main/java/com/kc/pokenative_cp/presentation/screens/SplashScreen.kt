package com.kc.pokenative_cp.presentation.screens

import android.app.Activity
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsControllerCompat
import com.kc.pokenative_cp.R
import com.kc.pokenative_cp.utils.AppColors
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onNavigateToHome: () -> Unit
) {

    val context = LocalContext.current
    LaunchedEffect(Unit) {
        if (context is Activity) {
            context.window.statusBarColor = AppColors.primary.toArgb()
            context.window.navigationBarColor = AppColors.primary.toArgb()
            WindowInsetsControllerCompat(context.window, context.window.decorView).isAppearanceLightStatusBars = false
        }
    }

    val scale = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            )
        )
        delay(2000)
        onNavigateToHome()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.primary),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_pokeball),
            contentDescription = "Pokeball Logo",
            modifier = Modifier
                .scale(scale.value)
                .size(180.dp)
        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    MaterialTheme {
        SplashScreen(
            onNavigateToHome = {}
        )
    }
}
