package com.kc.pokenative_cp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kc.pokenative_cp.presentation.components.AppNavbar
import com.kc.pokenative_cp.presentation.components.SortOption
import com.kc.pokenative_cp.utils.AppColors

@Composable
fun HomeScreen() {

    var query by rememberSaveable { mutableStateOf("") }
    var selectedSort by rememberSaveable { mutableStateOf(SortOption.NUMBER) }

    Scaffold(
        topBar = {
            AppNavbar(
                query = query,
                onQueryChanged = { query = it },
                selectedSort = selectedSort,
                onSortOptionSelected = { selectedSort = it }
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(AppColors.primary)
                .padding(12.dp)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .padding(12.dp)
            ) {
                Text(text = "Card")
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen()
    }
}