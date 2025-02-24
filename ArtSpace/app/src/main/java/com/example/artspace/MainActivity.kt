package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    val artworks = listOf(
        Artwork(R.drawable.placeholder, R.string.artwork_title_1, R.string.artist_name_1, R.string.artwork_year_1),
        Artwork(R.drawable.placeholder, R.string.artwork_title_2, R.string.artist_name_2, R.string.artwork_year_2),
        Artwork(R.drawable.placeholder, R.string.artwork_title_3, R.string.artist_name_3, R.string.artwork_year_3)
    )

    var currentArtworkIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.weight(1f))
        ArtworkSection(artworks[currentArtworkIndex])
        Spacer(modifier = Modifier.height(40.dp))
        ArtworkDescriptor(artworks[currentArtworkIndex])
        Spacer(modifier = Modifier.weight(1f))
        Buttons(
            onPrevious = {
                currentArtworkIndex = (currentArtworkIndex - 1 + artworks.size) % artworks.size
            },
            onNext = {
                currentArtworkIndex = (currentArtworkIndex + 1) % artworks.size
            }
        )
    }
}

data class Artwork(val imageResource: Int, val title: Int, val artist: Int, val year: Int)

@Composable
fun ArtworkSection(artwork: Artwork) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .shadow(6.dp),
        color = Color.White
    ) {
        Image(
            painter = painterResource(id = artwork.imageResource),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .aspectRatio(1f)
        )
    }
}

@Composable
fun ArtworkDescriptor(artwork: Artwork) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .shadow(4.dp),
        color = Color(0xFFEFEFF1)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = stringResource(id = artwork.title),
                fontWeight = FontWeight.Light,
                fontSize = 22.sp,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(
                    text = stringResource(id = artwork.artist),
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "(${stringResource(id = artwork.year)})",
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun Buttons(onPrevious: () -> Unit, onNext: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onPrevious,
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F4E8C)),
            modifier = Modifier.weight(1f).padding(horizontal = 8.dp)
        ) {
            Text(text = "Previous", color = Color.White)
        }
        Button(
            onClick = onNext,
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F4E8C)),
            modifier = Modifier.weight(1f).padding(horizontal = 8.dp)
        ) {
            Text(text = "Next", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceApp()
}
