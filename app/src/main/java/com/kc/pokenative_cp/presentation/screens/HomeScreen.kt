package com.kc.pokenative_cp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kc.pokenative_cp.presentation.components.AppNavbar
import com.kc.pokenative_cp.presentation.components.PokeballLoader
import com.kc.pokenative_cp.presentation.components.PokemonItem
import com.kc.pokenative_cp.presentation.components.SortOption
import com.kc.pokenative_cp.utils.AppColors
import kotlinx.coroutines.delay

data class Pokemon(
    val name: String,
    val number: String,
    val imageUrl: String
)

@Composable
fun HomeScreen() {

    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(5500)
        isLoading = false
    }

    var query by rememberSaveable { mutableStateOf("") }
    var selectedSort by rememberSaveable { mutableStateOf(SortOption.NUMBER) }

    val pokemonList = listOf(
        Pokemon("Bulbasaur", "001", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"),
        Pokemon("Ivysaur", "002", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/2.png"),
        Pokemon("Venusaur", "003", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/3.png"),
        Pokemon("Charmander", "004", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png"),
        Pokemon("Charmeleon", "005", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/5.png"),
        Pokemon("Charizard", "006", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/6.png"),
        Pokemon("Squirtle", "007", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/7.png"),
        Pokemon("Wartortle", "008", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/8.png"),
        Pokemon("Blastoise", "009", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/9.png"),
        Pokemon("Caterpie", "010", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/10.png"),
        Pokemon("Metapod", "011", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/11.png"),
        Pokemon("Butterfree", "012", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/12.png"),
        Pokemon("Weedle", "013", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/13.png"),
        Pokemon("Kakuna", "014", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/14.png"),
    )

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
            if (isLoading) {
                PokeballLoader()
            }else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                        .padding(12.dp)
                ) {
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = 80.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(pokemonList.size) { index ->
                            val pokemon = pokemonList[index]
                            PokemonItem(
                                pokemonName = pokemon.name,
                                pokemonNumber = pokemon.number,
                                pokemonImageUrl = pokemon.imageUrl,
                                onPokemonClick = {}
                            )
                        }
                    }
                }
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