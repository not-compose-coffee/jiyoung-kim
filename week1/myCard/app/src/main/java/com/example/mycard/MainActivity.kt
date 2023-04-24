package com.example.mycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycard.ui.theme.MyCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CardPreview()
                }
            }
        }
    }
}

@Composable
fun MyProfile(
    image: Painter,
    name: String,
    job: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape),
            painter = image,
            contentDescription = null
        )

        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(text = job, fontSize = 18.sp, color = Color(0xff808080))
    }
}

@Composable
fun MyInfo(
    icon: ImageVector,
    content: String
) {
    Row {
        Icon(imageVector = icon, contentDescription = null, tint = Color(0xff41644A))
        Spacer(modifier = Modifier.padding(end = 10.dp))
        Text(content)
    }
    Spacer(modifier = Modifier.padding(top = 10.dp))
}

@Composable
fun MyCardApp() {
    Column(
        modifier = Modifier.fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyProfile(painterResource(id = R.drawable.profile_image), "김지영", "Android Developer")
        Column(
            modifier = Modifier.padding(top = 40.dp),
            horizontalAlignment = Alignment.Start
        ) {
            MyInfo(icon = Icons.Default.Phone, "010-1234-1234")
            MyInfo(icon = Icons.Default.Share, "zzi.__.0")
            MyInfo(icon = Icons.Default.Email, "aaa@naver.com")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    MyCardTheme {
        MyCardApp()
    }
}
