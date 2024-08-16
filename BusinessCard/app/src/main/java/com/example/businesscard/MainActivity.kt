package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFD2E8D4)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier
                .fillMaxHeight()
                .padding(vertical = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            IconCard()
            ConnectList(Modifier.align(Alignment.BottomCenter))
        }
    }
}

@Composable
private fun IconCard(modifier: Modifier = Modifier) {
    Column(
        modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box() {
            val image = painterResource(R.drawable.android_logo)
            Image(
                painter = image,
                contentDescription = null,
                Modifier
                    .size(120.dp)
                    .background(Color(0xFF073042))
            )
        }
        Text(
            text = stringResource(R.string.full_name),
            fontSize = 48.sp,
            lineHeight = 64.sp,
            fontWeight = FontWeight.W300
        )
        Text(
            text = stringResource(R.string.work),
            fontWeight = FontWeight.Bold,
            color = Color(0xff056f3e)
        )
    }
}

@Composable
private fun ConnectList(modifier: Modifier = Modifier) {
    Column(modifier) {
        ConnectItem(Icons.Filled.Call, stringResource(R.string.phone))
        ConnectItem(Icons.Filled.Share, stringResource(R.string.share))
        ConnectItem(Icons.Filled.Email, stringResource(R.string.email))
    }
}

@Composable
private fun ConnectItem(icon: ImageVector, text: String) {
    Row(
        Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xff056f3e)
        )
        Text(text, modifier = Modifier.padding(start = 24.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}