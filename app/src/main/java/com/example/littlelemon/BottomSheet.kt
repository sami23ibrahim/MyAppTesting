package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BottomSheetContent() { // this is only the content that will
                           // be used inside the BottomSheetScaffoldWithContent()
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.background(color = Color.LightGray)
            .padding(10.dp).fillMaxWidth()
    )
    {

        Image(
            painter = painterResource(id = R.drawable.pizza2),
            contentDescription = "Orders",
            modifier = Modifier.size(90.dp)
        )
        Spacer(modifier = Modifier.size(6.dp))

        Image(
            painter = painterResource(id = R.drawable.pizza2),
            contentDescription = "Account",
            modifier = Modifier.size(90.dp)
        )
        Spacer(modifier = Modifier.size(6.dp))

        Image(
            painter = painterResource(id = R.drawable.pizza2),
            contentDescription = "Basket",
            modifier = Modifier.size(90.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun  BottomSheetContentPreview() {
    BottomSheetContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScaffoldWithContent( scaffoldState: BottomSheetScaffoldState, mainContent: @Composable (Modifier) -> Unit)
    /*
    @Composable (Modifier) -> Unit: This is a higher-order function that takes a Modifier as its
     parameter and returns Unit (which means it doesn't return anything). It is a composable
     function itself, indicated by the @Composable annotation. This parameter is designed to
     receive the main content of your screen as a composable function.
     */
 {
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = { BottomSheetContent() }, // the BottomSheetContent composable here
        content = { paddingValues -> mainContent(Modifier.padding(paddingValues))
            // the content that will be displayed if the sheet is not slided up which
            // passed as mainContent: @Composable (Modifier) -> Unit in the parameter.
        }
    )
}
