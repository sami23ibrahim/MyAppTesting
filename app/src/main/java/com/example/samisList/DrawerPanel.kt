package com.example.littlelemon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DrawerPanel(onCloseClick: () -> Unit){//This lambda is a placeholder for some action that should
// occur when the IconButton is clicked. It is not defined within DrawerPanel itself, but rather it
// should be provided by the composable that calls DrawerPanel.

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp//Retrieves the current screen width.
    var drawerWidth = (screenWidth.value * 0.8).dp // Convert to Float, multiply, and convert back to Dp
   // val drawerWidth = if (isOpen) (screenWidth.value * 0.8).dp else 0.dp

    Column(
        modifier = Modifier

            .width(250.dp)
            .fillMaxHeight()  // This line will make the drawer take the full height
            .background(Color.White)
    ) {
        LazyColumn {
            items(5) { index ->
                Text(
                    text = "Item #$index",
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
                )
            }
        }
        IconButton(onClick = { onCloseClick() }) {

            Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Close Icon")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerPanelPreview() {
    //DrawerPanel()
}