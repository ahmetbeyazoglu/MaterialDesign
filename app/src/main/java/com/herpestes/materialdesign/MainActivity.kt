package com.herpestes.materialdesign

import android.os.Bundle
import android.telecom.Call.Details
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                    Sayfagecisleri()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialDesignTheme {
        
    }
}
fun Sayfagecisleri() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "sayfa"){
        composable("sayfa"){
            SayfaDinamikListeleme(navController = navController)
        }
        composable("details_sayfa/{ulkeAdi}", arguments = listOf(
            navArgument("ulkeAdi"){ type = NavType.StringType}
        )){
            val ulkeAdi = it.arguments?.getString("ulkeAdi")!!
            Details(ulkeAdi= ulkeAdi)
        }
    }
}

@Composable
fun SayfaDinamikListeleme(navController: NavController) {
    val ulkelistesi = remember { mutableListOf("Türkiye", "İtalya", "Almanya", "Japonya") }

    LazyColumn {
        items(
            count = ulkelistesi.count(),
            itemContent = {
                val ulke = ulkelistesi[it]

                Card(
                    modifier = Modifier
                        .padding(all = 5.dp)
                        .fillMaxWidth()
                ) {
                    Row(modifier = Modifier.clickable {
                        Log.e("Liste", "$ulke seçildi")
                    }) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .padding(all = 10.dp)
                                .fillMaxWidth()
                        ) {
                            Text(text = ulke, modifier = Modifier
                                .padding(all = 5.dp)
                                .clickable {
                                    Log.e("Liste", "Text ile $ulke seçildi")
                                })
                            OutlinedButton(onClick = {
                                Log.e("Liste", " Buton ile $ulke seçildi")
                            }) {
                                Text(text = "Ülke seç")
                            }
                        }
                    }

                }

            }
        )
    }

}

@Composable
fun SayfaSabitListeleme() {
    LazyRow {
        item {
            Card(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .size(100.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.clickable {
                        Log.e("Liste", "Güneş tıklandı")
                    }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.gunes_resim),
                            contentDescription = ""
                        )
                        Text(text = "Güneş", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .size(100.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.Center,modifier = Modifier.clickable {
                    Log.e("Liste", "Ay tıklandı")
                }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ay_resim),
                            contentDescription = ""
                        )
                        Text(text = "Ay", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }
    }

}
/*
@Composable
fun SayfaSabitListeleme() {
    LazyColumn {
        item {
            Card(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.clickable {
                    Log.e("Liste", "Güneş tıklandı")
                }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.gunes_resim),
                            contentDescription = ""
                        )
                        Text(text = "Güneş", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.clickable {
                    Log.e("Liste", "Ay tıklandı")
                }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ay_resim),
                            contentDescription = ""
                        )
                        Text(text = "Ay", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }
    }

}*/
/*
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


}*/

