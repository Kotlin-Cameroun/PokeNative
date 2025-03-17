package com.kc.pokenative_cp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(top = 68.dp, end = 16.dp)
                .shadow(8.dp, RoundedCornerShape(16.dp)),
            colors = CardDefaults.cardColors(containerColor = AppColors.primary)
        ) {
            Column(
                modifier = Modifier
                    .width(160.dp)
                    .padding(12.dp)
            ) {
                Text(
                    text = "Sort by:",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                Card(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(vertical = 8.dp)) {

                        // First Option
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onSortSelected(SortOption.NUMBER)
                                }
                                .padding(horizontal = 12.dp, vertical = 4.dp)
                        ) {
                            RadioButton(
                                selected = selectedSort == SortOption.NUMBER,
                                onClick = { onSortSelected(SortOption.NUMBER) },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = AppColors.primary,
                                    unselectedColor = AppColors.primary
                                )
                            )
                            Text(
                                text = "Number",
                                modifier = Modifier.padding(start = 4.dp),
                                color = AppColors.primary
                            )
                        }

                        // Second Option
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onSortSelected(SortOption.NAME)
                                }
                                .padding(horizontal = 12.dp, vertical = 4.dp)
                        ) {
                            RadioButton(
                                selected = selectedSort == SortOption.NAME,
                                onClick = { onSortSelected(SortOption.NAME) },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = AppColors.primary,
                                    unselectedColor = AppColors.primary
                                )
                            )
                            Text(
                                text = "Name",
                                modifier = Modifier.padding(start = 4.dp),
                                color = AppColors.primary
                            )
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun SortMenuPreview() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            // On affiche uniquement le contenu de SortMenu sans Popup
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .shadow(8.dp, RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(containerColor = AppColors.primary)
            ) {
                Column(
                    modifier = Modifier
                        .width(160.dp)
                        .padding(12.dp)
                ) {
                    Text(
                        text = "Sort by:",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )

                    Card(
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Column(modifier = Modifier.padding(vertical = 8.dp)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp, vertical = 4.dp)
                            ) {
                                RadioButton(
                                    selected = true,
                                    onClick = {},
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = AppColors.primary,
                                        unselectedColor = AppColors.primary
                                    )
                                )
                                Text(
                                    text = "Number",
                                    modifier = Modifier.padding(start = 4.dp),
                                    color = AppColors.primary
                                )
                            }

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp, vertical = 4.dp)
                            ) {
                                RadioButton(
                                    selected = false,
                                    onClick = {},
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = AppColors.primary,
                                        unselectedColor = AppColors.primary
                                    )
                                )
                                Text(
                                    text = "Name",
                                    modifier = Modifier.padding(start = 4.dp),
                                    color = AppColors.primary
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

