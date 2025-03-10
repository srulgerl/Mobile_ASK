package com.example.a30dayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.a30dayapp.model.Day
import com.example.a30dayapp.model.DayInfo.days
import com.example.a30dayapp.ui.theme.ThirtyDayAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThirtyDayAppTheme {
                Scaffold(
                    topBar = { TopBar() },
                    modifier = Modifier.fillMaxSize()
                ){
                    paddingValues ->
                    MindfullnessApp(modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues))
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "30 Days of Mindfulness"
            )

        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun MindfullnessApp(modifier: Modifier = Modifier){
    var currentIndex by remember { mutableIntStateOf(0) }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
    ){
        Spacer(modifier = Modifier.weight(1f))
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "DAY ${currentIndex + 1}: ",
                style = MaterialTheme.typography.displayMedium
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = stringResource(days[currentIndex].dayTitle),
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        AnimatedContent(
            targetState = days[currentIndex],
            transitionSpec = {
                val durationSlide = 400
                val durationFade = 200

                if (targetState.dayTitle > initialState.dayTitle) {
                    (slideInHorizontally(animationSpec = tween(durationSlide)) { it } +
                            fadeIn(animationSpec = tween(durationFade))) togetherWith
                            (slideOutHorizontally(animationSpec = tween(durationSlide)) { -it } +
                                    fadeOut(animationSpec = tween(durationFade)))
                } else {
                    (slideInHorizontally(animationSpec = tween(durationSlide)) { -it } +
                            fadeIn(animationSpec = tween(durationFade))) togetherWith
                            (slideOutHorizontally(animationSpec = tween(durationSlide)) { it } +
                                    fadeOut(animationSpec = tween(durationFade)))
                }
            },
            label = "Day Transition"
        ) { currentDay ->
            DayItem(day = currentDay, dayNumber = currentIndex + 1)
        }

        Spacer(modifier = Modifier.height(30.dp))
        Icons(
            currentIndex = currentIndex,
            onIndexChange = { newIndex -> currentIndex = newIndex }
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun DayItem(
    dayNumber: Int,
    day: Day,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(day.dayImage),
                contentDescription = stringResource(day.dayTitle),
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
            )
        }
        Text(
            text = stringResource(day.dayText),
            modifier = Modifier.padding(top = 30.dp, start = 30.dp, end = 30.dp),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Justify,
            lineHeight = 1.5.em
        )

    }
}

@Composable
fun Icons(
    modifier: Modifier = Modifier,
    currentIndex: Int,
    onIndexChange: (Int) -> Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
        ) {
        IconButton(
            onClick = { if(currentIndex > 0) onIndexChange(currentIndex-1) },
            enabled = currentIndex > 0,
            modifier = Modifier
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Previous Day"
            )
        }
        IconButton(
            onClick = {
                if(currentIndex < 30) onIndexChange(currentIndex + 1)
            },
            enabled = currentIndex < days.size,
            modifier = Modifier
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Next Day"
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AppThemePreview() {
    ThirtyDayAppTheme {
//        DayItem(days[0],modifier = Modifier.fillMaxSize())
        MindfullnessApp()
    }
}