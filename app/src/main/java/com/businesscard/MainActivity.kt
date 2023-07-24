package com.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(

    ) {
        Logo(name = "Martin Ntwiga", title = "Android Engineer")
        ContactInfo(telephone = "254728692675", socialHandle = "@Manene", email = "ntwiga@gmail.com")
    }
}

@Composable
fun Logo(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    
    Column(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .background(Color.Blue)
                .size(width = 60.dp, height = 70.dp)
        )
        Text(
            text = name,
        )
        Text(
            text = title,
            fontSize = 10.sp,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
        )
    }
}

@Composable
fun ContactInfo(telephone: String, socialHandle: String, email: String, modifier: Modifier = Modifier) {
    val myAppIcons = Icons.Filled
    Column(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
    ) {
        Row(

        ) {
            androidx.compose.material3.Icon(imageVector = myAppIcons.Phone, contentDescription = "phone number")
            Text(text = telephone)
        }
        Row(

        ) {
            androidx.compose.material3.Icon(imageVector = myAppIcons.Share, contentDescription = "social handle")
            Text(text = socialHandle)
        }
        Row(

        ) {
            androidx.compose.material3.Icon(imageVector = myAppIcons.Email, contentDescription = "email address")
            Text(text = email)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}