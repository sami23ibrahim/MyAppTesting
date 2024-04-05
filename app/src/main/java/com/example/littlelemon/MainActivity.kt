package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // MenuGrid ()
          //  LazyGridMenu ()
          //  DishDetails(1)
            MyNavigation()
        }
    }
}

//@androidx.compose.runtime.Composable
//@Composable
//fun LoginScreen(sharedViewModel: SharedViewModel, onLoginSuccess: () -> Unit) {
//    var text by remember { mutableStateOf("") }
//
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        TextField(
//            value = text,
//            onValueChange = { text = it },
//            label = { Text("Username") }
//        )
//        Button(onClick = {
//            sharedViewModel.updateUserName(text)
//            onLoginSuccess()
//        }) {
//            Text("Login")
//        }
//    }
//}
//
//
//
//@androidx.compose.runtime.Composable
//@Composable
//fun DisplayScreen(sharedViewModel: SharedViewModel) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text("Hello, ${sharedViewModel.userName.value}!")
//    }
//}
//

