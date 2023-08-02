package com.herpestes.materialdesign

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.herpestes.materialdesign.ui.theme.MaterialDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialDesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SayfaTopAppBar()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialDesignTheme {
        SayfaTopAppBar()
    }
}



@Composable
fun SayfaTopAppBar() {
    Scaffold(
        topBar = {
                 TopAppBar(
                     title = {
                        Column() {
                            Text(text = "Başlık")
                            Text(text = "Alt Başlık", fontSize = 13.sp)
                        }
                     },
                     backgroundColor = colorResource(id = R.color.anarenk),
                     contentColor = Color.White,
                     actions = {
                         Text(text = "Çıkış", modifier = Modifier.clickable { Log.e("TopBar", "Çıkış seçildi") })
                     }

                     )

        },
        content = {
            
        }

    )


}

