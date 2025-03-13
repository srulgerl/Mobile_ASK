package com.example.theunscramble

import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import com.example.theunscramble.ui.theme.TheUnscrambleTheme

import android.os.Bundle
import androidx.activity.ComponentActivity

import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.theunscramble.ui.GameScreen
import com.example.theunscramble.ui.theme.TheUnscrambleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            TheUnscrambleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    GameScreen()
                }
            }
        }
    }
}