package com.udit.openapps

import android.R
import android.R.attr.action
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.LinkAnnotation.Url
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.udit.openapps.ui.theme.OpenAppsTheme
import java.net.URL
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OpenAppsTheme {
                ImplicitIntentDemo();
            }
        }
    }
}

@Composable
fun ImplicitIntentDemo(){
    val context = LocalContext.current;
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Row(horizontalArrangement = Arrangement.Center) {
        Button(modifier = Modifier.padding(end = 5.dp),onClick = {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.google.com")
            }
            context.startActivity(intent)
        }) {
            Text("Open Google")
        }
            Button(modifier = Modifier.padding(end = 5.dp),onClick = {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, "Sharing text" + "using implicit intent!")
                }
                context.startActivity(Intent.createChooser(intent,"Share Via"))
            }) {
                Text("Text mes")
            }
    }
        Row(horizontalArrangement = Arrangement.Center) {
        Button(modifier = Modifier.padding(end = 5.dp),onClick = {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel: 7404522887")
            }
            context.startActivity(intent)
        }) {
            Text("Open DialPad")
        }
        Button(modifier = Modifier.padding(end = 5.dp), onClick = {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://youtu.be/xvFZjo5PgG0?si=Ab9dG3HfDxN0ytle")
            }
            context.startActivity(intent)
        }) {
            Text("Open Youtube", fontWeight = FontWeight.Bold, color = Color.Red)
        }
    }
        Row(horizontalArrangement = Arrangement.Center) {
        Button(modifier = Modifier.padding(end = 5.dp),onClick = {
            val intent = Intent(Intent.ACTION_PICK).apply {
                type = "image/*"
            }
            context.startActivity(intent)
        }) {
            Text("Open Gallery")
        }
        Button(modifier = Modifier.padding(end = 5.dp), onClick = {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                putExtra("android.intent.extras.CAMERA_FACING", 1) // Front camera
                putExtra("android.intent.extra.USE_FRONT_CAMERA", true)
                putExtra("android.intent.extras.LENS_FACING_FRONT", 1)

            }
            context.startActivity(intent)
        }) {
            Text("Udit's Girlfriend")
        }
    }
        Row(horizontalArrangement = Arrangement.Center) {

        Button(modifier = Modifier.padding(end = 5.dp),onClick = {val intent = Intent(Intent.ACTION_GET_CONTENT).apply{
            type = "document/pdf"
        }
            context.startActivity(intent)
        }) {
            Text("Open Documents")
        }
        Button(modifier = Modifier.padding(end = 5.dp),onClick = {val intent = Intent(Intent.ACTION_SENDTO).apply{
            data = Uri.parse("mailto:uditjangrax@gmail.com")
            putExtra(Intent.EXTRA_SUBJECT, "Why Saksham is cool?")
        }
            context.startActivity(intent)
        }) {
            Text("Mail Me")
        }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OpenAppsTheme {
        ImplicitIntentDemo();
    }
}