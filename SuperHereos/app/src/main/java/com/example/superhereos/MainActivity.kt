package com.example.superhereos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superhereos.ui.theme.SuperheroesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme{
                Scaffold(
                    topBar = {SuperheroesTopAppBar()},
                    modifier = Modifier.fillMaxSize()
                ){
                    paddingValues ->
                    HeroesScreen(modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues))
                }

            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperheroesTopAppBar(){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "SuperHeroes",
                style = MaterialTheme.typography.displayLarge
            )
        },
        modifier = Modifier.fillMaxWidth()
    )
}



@Preview(showBackground = true)
@Composable
fun HeroPreview() {
    SuperheroesTheme (){
        HeroesScreen(modifier = Modifier.fillMaxSize())
//        SuperheroesTopAppBar()
    }
}
@Preview(showBackground = true)
@Composable
fun HeroDarkPreview() {
    SuperheroesTheme (darkTheme = true){
        HeroesScreen(modifier = Modifier.fillMaxSize())
//        SuperheroesTopAppBar()
    }
}