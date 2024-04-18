package com.example.littlelemon
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(drawerState: DrawerState,
              scope: CoroutineScope,


){
   // val userName = sharedViewModel.userName.value
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
            .background(Color(0xFF1F7CA0)),
          //  .background(Color( 0xffcb112c)),


         //   .background(Color.Green)

        verticalAlignment = Alignment.CenterVertically
    )
    {



        IconButton(onClick = {
            scope.launch {
                if (drawerState.isOpen) {
                    drawerState.close()
                } else {
                    drawerState.open()
                }
            }
        }
        )



        {Icon(imageVector= Icons.Default.Menu,
            contentDescription = " Menu Icon ",
                modifier= Modifier.size(24.dp)
                    ,tint = Color.White)
        }

//        Text(
//            text =" welcome " + UserName.getUserName(),
//            fontSize = 16.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color(0xFF1F7CA0),
//            modifier = Modifier.padding(start = 3.dp, top = 1.dp)
//        )
        Image(painter = painterResource(id = R.drawable.adonis2) ,
            contentDescription = "Logo",
            modifier= Modifier.fillMaxWidth(0.5F)
                .padding(horizontal = 20.dp)
                .height(51.dp)
        )
        IconButton(onClick = { /*TODO*/
        }) {Icon(imageVector= Icons.Default.ShoppingCart,
            contentDescription = " Cart ",
            modifier= Modifier.size(24.dp) ,tint = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    val mockDrawerState = rememberDrawerState(DrawerValue.Closed)
    val mockScope = rememberCoroutineScope()
    TopAppBar(drawerState = mockDrawerState, scope = mockScope)
}
