


package com.example.businesscard

import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.view.Display.Mode
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardAppTheme
import com.example.businesscardapp.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    BusinessCardScreen(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen(modifier: Modifier){

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(200,227,203)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        ProfileSection(
            modifier = Modifier.fillMaxWidth(),

            )
        Spacer(modifier.height(20.dp))
        ContactSection(
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier.size(120.dp)
                .background(Color(0xFF0A2432)))
        Text(
            modifier = Modifier.padding(0.dp, 7.dp, 0.dp, 5.dp),
            text = "Full name",
            fontSize = 40.sp,
            fontWeight = FontWeight.W300
        )
        Text(
            text = "title",
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF2E7D32)
        )
    }
}

@Composable
fun ContactSection(modifier: Modifier){
    Column (
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        ContactRow()
        ContactRow()
        ContactRow()
    }
}

@Composable
fun ContactRow(name: String, modifier: Modifier){
    Icon(
        painter = painterResource(),
        contentDescription = null,
    )
    Text(
        text = "+",
        fontSize = 12.sp
    )
}




@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCardScreen(modifier = Modifier)
    }
}

