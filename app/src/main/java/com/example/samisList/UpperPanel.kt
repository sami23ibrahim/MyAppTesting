package com.example.littlelemon

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UpperPanel(userName: String? = "", navController: NavHostController? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .background(Color(android.graphics.Color.parseColor("#9fc5e8"))),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f) // This makes the column take up available space
            ) {
                Text(
                    text = "    GRILLADES",//+ UserName.getUserName(),
                     //      + " Hi,$userName",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color =Color((android.graphics.Color.parseColor("#d44d4d"))),
                    modifier = Modifier.padding(start = 23.dp, top = 1.dp)
                )

                Text(
                    text = "Middle Eastern, Lebanese, and Mediterranean-inspired food.",
                    fontSize = 21.sp,
                    color = Color(0xFFFFFFFF)
                    // Add any other modifiers as needed
                )
                // Add any other texts or elements here inside the Column
            }

            Image(
                painter = painterResource(id = R.drawable.pizza2),
                contentDescription = "img",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterVertically) // Align the image vertically within the Row
            )
        }
    }
}
@Composable
fun FullWidthImage(imageId: Int, imageHeight: Dp) {
    val image: Painter = painterResource(id = imageId)
    Image(
        painter = image,
        contentDescription = "Full Width Image",
        modifier = Modifier.shadow(elevation = 0.dp, shape = RoundedCornerShape(4.dp)) // Adding shadow with elevation
            .fillMaxWidth() // This will make the image use the full width of its parent

            .height(imageHeight), // Set the height you want here
        contentScale = ContentScale.FillWidth // This will scale the image to fill the width
    )
}

@Preview(showBackground = true)
@Composable
fun FullWidthImagePreview() {
    // Replace with your actual drawable resource ID
    // For the preview to work, the image must exist in your project's 'res/drawable' directory
    FullWidthImage(imageId = R.drawable.greeksalad, imageHeight = 100.dp)
}


@Preview(showBackground = true)
@Composable
fun MainComponentPreview() {
   UpperPanel()
}