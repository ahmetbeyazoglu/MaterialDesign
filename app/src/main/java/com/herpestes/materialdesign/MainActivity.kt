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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
                    SayfaTopAppBarArama()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialDesignTheme {
        SayfaTopAppBarArama()
    }
}
@Composable
fun SayfaTopAppBarArama() {
    val aramayapiliyormu = remember { mutableStateOf(false) }
    val tf = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                    if(aramayapiliyormu.value){
                        TextField(
                            value = tf.value,
                            onValueChange = {
                                tf.value = it
                                Log.e("TopBar", "Arama: $it")
                                            },
                            label = { Text(text = "Ara")}
                        )

                    }else{
                        Text(text = "Başlık")
                    }
                },
                backgroundColor = colorResource(id = R.color.anarenk),
                contentColor = Color.White,
                actions = {
                    if (aramayapiliyormu.value) {
                        IconButton(onClick = {
                            aramayapiliyormu.value = false
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.kapat_resim),
                                contentDescription = ""
                            )
                        }
                    }else{
                        IconButton(onClick = {
                            aramayapiliyormu.value = false
                            tf.value = ""
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.arama_resim),
                                contentDescription = ""
                            )
                        }
                    }
                }
            )
        },
        content = {

        }
    )
}
@Composable
fun SayfaTopAppBar() {
    val menuAcilisKontrol = remember { mutableStateOf(false) }
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
                         IconButton(onClick = { 
                             Log.e("TopBar", "Info seçildi")
                         }) {
                             Icon(painter = painterResource(id = R.drawable.info_resim), contentDescription = "")
                         }
                         IconButton(onClick = {
                             //Log.e("TopBar", "More seçildi")
                             menuAcilisKontrol.value = true
                         }) {
                             Icon(painter = painterResource(id = R.drawable.more_resim), contentDescription = "")
                         }

                         DropdownMenu(expanded = menuAcilisKontrol.value,
                             onDismissRequest = { menuAcilisKontrol.value = false }) {
                             DropdownMenuItem(onClick = {
                                 Log.e("TopBar", "Menu sil seçildi")
                                 menuAcilisKontrol.value = false
                             }) {
                                 Text(text = "Sil")
                             }
                             DropdownMenuItem(onClick = {
                                 Log.e("TopBar", "Güncelle sil seçildi")
                                 menuAcilisKontrol.value = false
                             }) {
                                 Text(text = "Güncelle")
                             }
                             
                         }

                     }


                     )

        },
        content = {
            
        }

    )


}

