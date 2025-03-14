package com.kc.pokenative_cp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.kc.pokenative_cp.utils.AppColors


enum class SortOption {
    NUMBER, NAME
}

@Composable
fun SortMenu(
    selectedSort: SortOption,
    onSortSelected: (SortOption) -> Unit,
    onDismiss: () -> Unit
) {
    Popup(
        alignment = Alignment.TopEnd,
        onDismissRequest = onDismiss
    ) {

        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .background(AppColors.primary)
                .padding(top = 68.dp, end = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .width(160.dp)
                    .padding(12.dp)
            ) {

                Text(
                    text = "Sort by:",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.White,
                    modifier = Modifier
                        .padding(bottom = 9.dp)
                )

                Card(
                    modifier = Modifier
                        .background(Color.White),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Row(
                           verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedSort == SortOption.NUMBER,
                                onClick = { onSortSelected(SortOption.NUMBER) },
                                colors = RadioButtonDefaults.colors(selectedColor = AppColors.primary)
                            )
                            Text(text = "Number", modifier = Modifier.clickable {
                                onSortSelected(SortOption.NUMBER)
                            })
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedSort == SortOption.NAME,
                                onClick = { onSortSelected(SortOption.NAME) },
                                colors = RadioButtonDefaults.colors(selectedColor = AppColors.primary)
                            )
                            Text(text = "Number", modifier = Modifier.clickable {
                                onSortSelected(SortOption.NAME)
                            })
                        }
                    }
                }
            }
        }

    }
}


@Preview
@Composable
fun SortMenuPreview() {
    MaterialTheme {
        SortMenu(
            selectedSort = SortOption.NAME,
            onSortSelected = {},
            onDismiss = {}
        )
    }
}