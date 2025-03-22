package com.kc.pokenative_cp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.rememberAsyncImagePainter
import com.kc.pokenative_cp.utils.AppColors

@Composable
fun PokemonItem(
    pokemonName: String,
    pokemonNumber: String,
    pokemonImageUrl: String,
    onPokemonClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .size(124.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onPokemonClick() }
            .background(Color.White)
    ) {

        Text(
            text = "#$pokemonNumber",
            fontSize = 10.sp,
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(6.dp)
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(42.dp)
                .background(
                    color = AppColors.grayScale,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(vertical = 6.dp)
                .zIndex(0f)
        ) {
            Text(
                text = pokemonName,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Image(
            painter = rememberAsyncImagePainter(model = pokemonImageUrl),
            contentDescription = pokemonName,
            modifier = Modifier
                .align(Alignment.Center)
                .size(72.dp)
                .offset(y = (4).dp)
                .zIndex(1f) // passer au-dessus
        )

    }
}

@Preview
@Composable
private fun PokemonItemPreview() {
    MaterialTheme {
        PokemonItem(
            pokemonName = "Bulbasaur",
            pokemonNumber = "001",
            pokemonImageUrl = "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/001.png",
            onPokemonClick = {}
        )
    }
}