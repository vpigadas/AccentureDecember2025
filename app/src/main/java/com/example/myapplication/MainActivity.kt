package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.feature.Animal
import com.example.myapplication.feature.Cat
import com.example.myapplication.feature.Dalmatias
import com.example.myapplication.feature.Days
import com.example.myapplication.feature.Days2
import com.example.myapplication.feature.Fish
import com.example.myapplication.feature.HostException
import com.example.myapplication.feature.User4
import com.example.myapplication.feature.User5
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {

//                val user = User4(age = 100, name = "Vassilis!")
//                var user2 = User5("Markos!", age = 50)
//
//                val cat: Animal = Cat(100)
//
//                val dalmatias: Animal = Dalmatias(50)
//
//                val fish = Fish(50)

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(36.dp)
                ) { innerPadding ->
                    Greeting(
                        name = "Vassilis",
                        modifier = Modifier.padding(innerPadding)
                    )
                }

//                var day: Days = Days.M
//
//                when (day) {
//                    Days.M -> TODO()
//                    Days.Tu -> TODO()
//                    Days.W -> TODO()
//                    Days.Th -> TODO()
//                    Days.F -> TODO()
//                    Days.Sat -> TODO()
//                    Days.Sun -> TODO()
//                    Days.NEW -> TODO()
//                }
//
//                val days2: Days2 = Days2.W
//
//                when (days2) {
//                    Days2.F -> TODO()
//                    Days2.M -> TODO()
//                    Days2.Sat -> TODO()
//                    Days2.Sun -> TODO()
//                    Days2.Th -> TODO()
//                    Days2.Tu -> TODO()
//                    Days2.W -> TODO()
//                    is Days2.New -> days2.delay
//                }
//
//                val exception: HostException = HostException.TIME_OUT
//
//                when (exception) {
//                    is HostException.Exception -> when(exception.code){
//                        404 -> TODO()
//                        500 -> TODO()
//                    }
//                    HostException.NO_INTERNET -> TODO()
//                    HostException.TIME_OUT -> TODO()
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}