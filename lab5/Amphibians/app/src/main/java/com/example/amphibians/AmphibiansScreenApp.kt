package com.example.amphibians

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.amphibians.model.Amphibian
import com.example.amphibians.ui.theme.AmphibiansTheme

@Composable
fun AmphibiansScreen(viewModel: AmphibiansViewModel = viewModel()) {
    AmphibiansTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            when (val uiState = viewModel.uiState) {
                is UiState.Loading -> LoadingScreen()
                is UiState.Success -> AmphibiansListScreen(uiState.amphibians)
                is UiState.Error -> ErrorScreen()
                else -> {}
            }
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Error! Please try again.",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun AmphibiansListScreen(amphibians: List<Amphibian>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(amphibians) { amphibian ->
            AmphibianCard(amphibian = amphibian)
        }
    }
}

@Composable
fun AmphibianCard(amphibian: Amphibian, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column {
            Text(
                text = amphibian.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
            Image(
                painter = rememberAsyncImagePainter(amphibian.imgSrc),
                contentDescription = amphibian.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = amphibian.type,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = amphibian.description,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}