package com.udit.openapps

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.LinkAnnotation.Url
import androidx.compose.ui.tooling.preview.Preview
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
        ){
        Button(onClick = {val intent = Intent(Intent.ACTION_VIEW).apply {
             data = Uri.parse("https://www.google.com")
        }
            context.startActivity(intent)
        }) {
            Text("Open Google")
        }
        Button(onClick = {val intent = Intent(Intent.ACTION_DIAL).apply{
            data = Uri.parse("tel: 7404522887")
        }
            context.startActivity(intent)
        }) {
            Text("Open DialPad")
        }
        Button(onClick = {val intent = Intent(Intent.ACTION_VIEW).apply{
             data = Uri.parse("https://youtu.be/xvFZjo5PgG0?si=Ab9dG3HfDxN0ytle")
        }
            context.startActivity(intent)
        }) {
            Text("Open Youtube")
        }
        Button(onClick = {val intent = Intent(Intent.ACTION_PICK).apply{
            type = "image/*"
        }
            context.startActivity(intent)
        }) {
            Text("Open Gallery")
        }
        Button(onClick = {val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply{
            putExtra("android.intent.extras.CAMERA_FACING", 1) // Front camera
            putExtra("android.intent.extra.USE_FRONT_CAMERA", true)
            putExtra("android.intent.extras.LENS_FACING_FRONT", 1)

        }
            context.startActivity(intent)
        }) {
            Text("Udit's Girlfriend")
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