package com.example.littlelemon
import SharedViewModel
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.littlelemon.ui.theme.LittleLemonTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen( navController: NavHostController? = null) {
/*
Another approach is to make the navController parameter nullable
and provide a default value of null. In your actual app, you pass
the real NavHostController, while in the preview, you don't pass anything.
 */
    val sharedViewModel: SharedViewModel = viewModel() // This should be the same instance as in MyNavigation

    val context = LocalContext.current
    var username by rememberSaveable( ) { mutableStateOf("") }
    var password by rememberSaveable( ) { mutableStateOf("") }

    Column( modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally)
    {
//        Text(
//            text = UserName.getUserName(),
//            color = Color.Gray,
//
//            modifier = Modifier
//                .padding(top = 5.dp, bottom = 5.dp)
//                .fillMaxWidth(.75f)
//        )
        Image(
            painter = painterResource(id = R.drawable.adonis),
            modifier=Modifier.padding(10.dp),
            contentDescription = "Logo Image"

        )
        TextField(
            modifier=Modifier.padding(6.dp).background(color = Color.Transparent),

            shape = RoundedCornerShape(17.dp),
            value = username,  // Bind the text field value to the username variable
            onValueChange = { username = it },  // Update username variable when text changes
            label = { Text("Username") }, // Label for the TextField
            colors = TextFieldDefaults.textFieldColors(
              //  backgroundColor = Color.Black, // Replace with your desired color
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            )
        )
        sharedViewModel.setUserName(username)
        TextField(
            modifier=Modifier.padding(6.dp),
            shape = RoundedCornerShape(17.dp),
            value = password,  // Bind the text field value to the password variable
            onValueChange = { password = it },  // Update password variable when text changes
            label = { Text("Password") },
            colors = TextFieldDefaults.textFieldColors(
                //  backgroundColor = Color.Black, // Replace with your desired color
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            )
        )
        Button(
            onClick = {  if ((password =="1234")&&(username=="sami" )){

                Toast.makeText(context,"Welcome back ${sharedViewModel.userName.value}" , Toast.LENGTH_SHORT).show()
                UserName.setUserName(username)
                navController?.navigate("Home?NavHostName=${sharedViewModel.userName.value}")
                         //   navController?.navigate("Home?name=$username")
/*
Using Safe Call (?.)
Safe calls are a common way to deal with nullable types in Kotlin.
You use the ?. operator to safely call a method on a nullable object.
If the object is null, the method won't be called, and the expression evaluates to null.
 */

                         }else(Toast.makeText(context,"Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show()
                          )
                      },
            shape = RoundedCornerShape(7.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(android.graphics.Color.parseColor("#cb112c")), // red background
                contentColor = Color(android.graphics.Color.parseColor("#EDEFEE")) // Text color
            ),
            modifier = Modifier.padding(6.dp)
        ) {
            Text("Login", fontSize = 20.sp)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun  LoginScreenComponent() {
    LittleLemonTheme {
       LoginScreen()
    }
}