package com.kc.pokenative_cp.presentation.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowInsetsControllerCompat
import com.kc.pokenative_cp.R
import com.kc.pokenative_cp.utils.AppColors


@Composable
fun AppNavbar(
    query: String,
    onQueryChanged: (String) -> Unit,
    selectedSort: SortOption,
    onSortOptionSelected: (SortOption) -> Unit,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current
    LaunchedEffect(Unit) {
        if (context is Activity) {
            context.window.statusBarColor = AppColors.primary.toArgb()
            context.window.navigationBarColor = AppColors.primary.toArgb()
            WindowInsetsControllerCompat(context.window, context.window.decorView).isAppearanceLightStatusBars = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppColors.primary)
            .padding(10.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_pokeball),
                contentDescription = "Pokédex Logo",
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Pokédex",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        CustomSearchBar(
            query = query,
            onQueryChanged = onQueryChanged,
            selectedSort = selectedSort,
            onSortOptionSelected = onSortOptionSelected
        )
    }
}


@Preview
@Composable
private fun AppNavbarPreview() {
    MaterialTheme {
        AppNavbar(
            query = "",
            onQueryChanged = {},
            selectedSort = SortOption.NAME,
            onSortOptionSelected = {},
        )
    }
}