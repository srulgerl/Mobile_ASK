package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface (
                    modifier = Modifier.fillMaxSize()
                )
                {
                    ComposeCards(
                        modifier = Modifier,
                        title = stringResource(R.string.title),
                        text = stringResource(R.string.text)
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeCards(modifier: Modifier, title: String, text: String){
    Column (modifier = modifier.fillMaxWidth()){
        Row (modifier = modifier
            .weight(1f)
        ) {
            ComposeCard(
                modifier = modifier.weight(1f),
                title = stringResource(R.string.title),
                text = stringResource(R.string.text),
                backgroundColor = Color(0xFFEADDFF),
            )
            ComposeCard(
                modifier = modifier.weight(1f),
                title = stringResource(R.string.title),
                text = stringResource(R.string.text),
                backgroundColor = Color(0xFFD0BCFF),

            )
        }
        Row(
            modifier = modifier
                .weight(1f)
        )
        {
            ComposeCard(
                modifier = modifier.weight(1f),
                title = stringResource(R.string.title),
                text = stringResource(R.string.text),
                backgroundColor = Color(0xFFD0BCFF)

            )
            ComposeCard(
                modifier = modifier.weight(1f),
                title = stringResource(R.string.title),
                text = stringResource(R.string.text),
                backgroundColor = Color(0xFFEADDFF)
            )
        }
    }

}

@Composable
fun ComposeCard(modifier: Modifier, title: String, text: String, backgroundColor: Color){
    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = title,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify,
            fontSize = 14.sp
        )
    }
}

//@Composable
//fun ComposeCard(){
//    Column(modifier = Modifier
//        .fillMaxHeight()
//        .fillMaxWidth(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    )  {
//        Row (modifier = Modifier
//            .weight(1f).
//            fillMaxHeight(),
//        ){
//            Column(
//                modifier = Modifier.weight(1f)
//                    .fillMaxHeight()
//                    .background(color = Color(0xFFEADDFF))
//                    .padding(16.dp),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//
//            ) {
//                Text(
//                    modifier = Modifier.padding(bottom = 16.dp),
//                    text = "Text composable",
//                    fontWeight = FontWeight.Bold
//
//                )
//                Text(
//                    text = "Displays text and follows the recommended Material Design guidelines.\n",
//                    textAlign = TextAlign.Justify,
//                    fontSize = 14.sp
//                )
//            }
//            Column(
//                modifier = Modifier.weight(1f)
//                    .fillMaxHeight()
//                    .background(color = Color(0xFFD0BCFF))
//                    .padding(16.dp),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    modifier = Modifier.padding(bottom = 16.dp),
//                    text = "Image composable",
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = "Creates a composable that lays out and draws a given Painter class object.\n",
//                    textAlign = TextAlign.Justify,
//                    fontSize = 14.sp
//                )
//            }
//        }
//        Row(modifier = Modifier.weight(1f).fillMaxHeight()
//        ) {
//            Column(
//                modifier = Modifier.weight(1f)
//                    .fillMaxHeight()
//                    .background(color = Color(0xFFB69DF8))
//                    .padding(16.dp),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//            ) {
//                Text(
//                    modifier = Modifier.padding(bottom = 16.dp),
//                    text = "Row composable",
//                    fontWeight = FontWeight.Bold
//
//                )
//                Text(
//                    text = "A layout composable that places its children in a horizontal sequence.\n",
//                    textAlign = TextAlign.Justify,
//                    fontSize = 14.sp
//                )
//            }
//            Column(
//                modifier = Modifier.weight(1f)
//                    .fillMaxHeight()
//                    .background(color = Color(0xFFF6EDFF))
//                    .padding(16.dp),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//            ) {
//                Text(
//                    modifier = Modifier.padding(bottom = 16.dp),
//                    text = "Column composable",
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = "A layout composable that places its children in a vertical sequence.",
//                    textAlign = TextAlign.Justify,
//                    fontSize = 14.sp
//                )
//            }
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposeCards(
            modifier = Modifier,
            title = stringResource(R.string.title),
            text = stringResource(R.string.text))
    }
}