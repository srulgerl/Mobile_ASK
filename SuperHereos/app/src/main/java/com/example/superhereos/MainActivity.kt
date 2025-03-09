package com.example.superhereos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.superhereos.ui.theme.SuperheroesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme{
                HeroesScreen(modifier = Modifier.fillMaxSize())
            }

        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun heroPreview(){
//    HeroesScreen()
//}
