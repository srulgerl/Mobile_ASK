package com.example.thelearntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thelearntogether.ui.theme.TheLearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheLearnTogetherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                )
                {
                    BackgroundImage(
                        title =  stringResource(R.string.title),
                        header = stringResource(R.string.header),
                        body = stringResource(R.string.body)
                    )
                }
            }
        }
    }
}

@Composable
fun TutorialText(modifier: Modifier = Modifier, title: String, header: String, body: String) {
    Column() {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)

        )
        Text(
            text = header,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify

        )
        Text(
            text = body,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify

        )
    }
}

@Composable
fun BackgroundImage( modifier: Modifier = Modifier, title: String, header: String, body: String){
    val image = painterResource(R.drawable.bg_compose_background)
    Column(){
        Image(
            painter = image,
            contentDescription = null,

        )
        TutorialText(
            modifier = Modifier
                .fillMaxWidth(),
            title = title,
            header = header,
            body = body


        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheLearnTogetherTheme {
        BackgroundImage(
            title = stringResource(R.string.title),
            header = stringResource(R.string.header),
            body = stringResource(R.string.body)
        )
    }
}